#!/bin/bash

DOCKER_TAG=localhost:1234/ci/jenkins

if [ $# -gt 0 ]; then
  DOCKER_TAG=$1
fi

docker build -f Dockerfile . -t $DOCKER_TAG

docker run \
  --rm \
  -u root \
  -p 1234:8080 \
  -v jenkins-data:/var/jenkins_home \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v "$HOME":/home \
  localhost:1234/ci/jenkins:latest