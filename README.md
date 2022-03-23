# Temporal-order Demo Project

source: https://viblo.asia/p/temporal-workflow-trong-quarkus-bJzKmAgkK9N

Tác giả:

    + Duy Nguyễn
    + Chu Văn Hạnh

# Cài đặt Temporal
docker-compose.yml
```shell
version: "3.5"
services:
  elasticsearch:
    container_name: temporal-elasticsearch
    environment:
      - cluster.routing.allocation.disk.threshold_enabled=true
      - cluster.routing.allocation.disk.watermark.low=512mb
      - cluster.routing.allocation.disk.watermark.high=256mb
      - cluster.routing.allocation.disk.watermark.flood_stage=128mb
      - discovery.type=single-node
      - ES_JAVA_OPTS=-Xms100m -Xmx100m
    image: elasticsearch:7.16.2
    networks:
      - temporal-network
    ports:
      - 9200:9200
  postgresql:
    container_name: temporal-postgresql
    environment:
      POSTGRES_PASSWORD: temporal
      POSTGRES_USER: temporal
    image: postgres:13
    networks:
      - temporal-network
    ports:
      - 5432:5432
  temporal:
    container_name: temporal
    depends_on:
      - postgresql
      - elasticsearch
    environment:
      - DB=postgresql
      - DB_PORT=5432
      - POSTGRES_USER=temporal
      - POSTGRES_PWD=temporal
      - POSTGRES_SEEDS=postgresql
      - DYNAMIC_CONFIG_FILE_PATH=config/dynamicconfig/development_es.yaml
      - ENABLE_ES=true
      - ES_SEEDS=elasticsearch
      - ES_VERSION=v7
    image: temporalio/auto-setup:1.15.0
    networks:
      - temporal-network
    ports:
      - 7233:7233
    volumes:
      - ./dynamicconfig:/etc/temporal/config/dynamicconfig
  temporal-admin-tools:
    container_name: temporal-admin-tools
    depends_on:
      - temporal
    environment:
      - TEMPORAL_CLI_ADDRESS=temporal:7233
    image: temporalio/admin-tools:1.15.0
    networks:
      - temporal-network
    stdin_open: true
    tty: true
  temporal-web:
    container_name: temporal-web
    depends_on:
      - temporal
    environment:
      - TEMPORAL_GRPC_ENDPOINT=temporal:7233
      - TEMPORAL_PERMIT_WRITE_API=true
    image: temporalio/web:1.13.0
    networks:
      - temporal-network
    ports:
      - 8088:8088
networks:
  temporal-network:
    driver: bridge
    name: temporal-network

```

Url mặc định của Temporal UI: http://localhost:8088

# Chạy project

```shell
./mvnw compile quarkus:dev
```

Truy cập: http://localhost:8080/q/swagger-ui/


