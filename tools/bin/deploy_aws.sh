#!/bin/sh
set -e

ENV="$1"
if [ "$ENV" = "" ] ; then
    echo "Specify an environment.  (dev, sit, uat or prod)"
    exit 1
fi

echo Deploying to AWS $ENV
echo
mvn clean verify -P$ENV $2

if [ "$?" -ne 0 ]; then
    echo "Build failed.  Check the test results for errors."
    exit 1
fi

# database update
#mvn process-resources liquibase:update -P$ENV -DskipTests
# application deployment
mvn clean package beanstalk:upload-source-bundle beanstalk:create-application-version beanstalk:update-environment -P$ENV -DskipTests
