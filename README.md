## Dev Environment
### Required CLI tools
- `readability`: install with `npm i readability-cli --global`
- `ebook-convert`: install from https://calibre-ebook.com/download

### Docker compose
Start the dependencies declared in docker-compose.yml by runnign `docker compose up -d`
Then run the application inside your preferred IDE

### Run configuration
Run with the system property variables set to below values by passing in the VM arguments with `-D{key}={value}`

|key|value|description|
|---|---|---|
|NOVEL_SERVICE_CONFIG_FILE|<path-to-repo>/novel-service-config.yml|Config file location|
|NOVEL_FOLDER_KEY|Any valid folder path|A folder to save novels|
