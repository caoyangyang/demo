#!/bin/sh

bucket_path='bucket-name-here'
sync_time=$(date +%Y-%m-%d_%H-%M-%S)

echo "===> start sync bucket data before delete <==="
echo "sync data to s3_back_up/$bucket_path/$sync_time"
aws s3 sync s3://"$bucket_path" s3_back_up/"$bucket_path/$sync_time" > logs/S3FilesToLocal."$bucket_path-$sync_time".log

echo "===> start remove unused json file <==="
s3_files=("dir1/file1"
"dir1/file2"
"dir2/file3"
)

s3_directories=("dir3/")
for fileName in "${s3_files[@]}"
do
  s3_file=s3://"$bucket_path/$fileName"
  aws s3 rm $s3_file >> logs/S3DeleteFiles."$bucket_path-$sync_time".log
  echo "remove file $s3_file"
done

for directory_name in "${s3_directories[@]}"
do
  s3_directory=s3://"$bucket_path/$directory_name"
  aws s3 rm $s3_directory --recursive --exclude ""  >> logs/S3DeleteFiles."$bucket_path-$sync_time".log
  echo "remove directory $s3_directory"
done