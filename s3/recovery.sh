#!/bin/sh

bucket_path='bucket-name-here'
recover_time=$(date +%Y-%m-%d_%H-%M-%S)
sync_time=$1

echo "===> start recover s3 bucket data at $recover_time <===" >> logs/S3RecoverFiles."$bucket_path-$sync_time".log
echo "===> recover from s3_back_up/$bucket_path/$sync_time <==="
aws s3 sync  s3_back_up/"$bucket_path/$sync_time" s3://"$bucket_path"  --acl public-read >> logs/S3RecoverFiles."$bucket_path-$sync_time".log
