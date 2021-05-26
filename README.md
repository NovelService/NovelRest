# Novel Rest

[![CI](https://github.com/NovelService/NovelRest/actions/workflows/ci.yml/badge.svg?branch=master&event=push)](https://github.com/NovelService/NovelRest/actions/workflows/ci.yml)
[![Docker Pulls](https://img.shields.io/docker/pulls/xiangronglin/novel-rest)](https://hub.docker.com/repository/docker/xiangronglin/novel-rest)

## Description
The public API for the Novel Service.
Allows to trigger the worker and fetch novels after they are finished

## Dev Environment
### Docker compose
In the project root create a file `.env` which contains variables needed for docker compose.

|key|value|description|
|---|---|---|
|project_root|\<path-to-repo\>|The full path to the repository on the local file system without trailing slash|
  
Start the dependencies declared in docker-compose.yml by running `docker compose up -d`  
Then run the application inside your preferred IDE

### Run configuration
Run with the system property variables set to below values by passing in the VM arguments with `-D{key}={value}`

|key|value|description|
|---|---|---|
|NOVEL_SERVICE_CONFIG_FILE|\<path-to-repo\>/novel-service-config.yml|Config file location|
|NOVEL_FOLDER_KEY|\<path-to-repo\>/data|A folder to save novels. Used by this and novel-worker|
