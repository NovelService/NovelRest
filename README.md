## Dev Environment
### Required CLI tools
- `readability`: install with `npm i readability-cli --global`
- `ebook-convert`: install from https://calibre-ebook.com/download

### Docker compose
Start the dependencies declared in docker-compose.yml by runnign `docker compose up -d`
Then run the application inside your preferred IDE

### Run configuration
Run with the environment variable set to `NOVEL_SERVICE_CONFIG_FILE=<path-to-repo>/novel-service-config.yml`
