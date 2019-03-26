# Demo

## Development requirements

  * Maven
  * Spring Boot
  * Spring Kafka
  * Zookeeper
  * Kafka
  * Postgres

### Install Zookeeper

```bash
$ brew install zookeeper
```

### Start Zookeeper

```bash
$ brew services start zookeeper
```

### Install Kafka

```bash
$ brew install kafka
```

### Start Kafka

```bash
$ brew services start kafka
```

### Install Postgres

```bash
$ brew install postgresql
```

### Start Postgres

```bash
$ brew services start postgresql
```

### Create database (Use your datasource username & password)

```bash
$ psql -U postgres

postgres=> create database postgres_order;

postgres=> create database postgres_shipment;

postgres=> create database postgres_invoice;
```

## Build

```bash
$ ./mvnw clean package
```

## Run

```bash
$ cd order
$ ./mvnw spring-boot:run
```

```bash
$ cd shipment
$ ./mvnw spring-boot:run
```

```bash
$ cd invoice
$ ./mvnw spring-boot:run
```

## Test

```curl
curl -X POST \
  http://localhost:8081/orders \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
    "customer": {
        "customerId": 1,
        "name": "Steve Payne",
        "email": "steve.payne@example.com"
    },
    "orderLine": [
        {
            "count": 2,
            "product": {
                "productId": 3,
                "name": "MacBook Air",
                "price": 1999
            }
        }
    ],
    "numberOfLines": 1,
    "address": {
        "street": "#1",
        "city": "LA",
        "zip": "12345"
    }
}'
```

```bash
$ curl http://localhost:8082/shipment
```

```bash
$ curl http://localhost:8082/invoice
```
