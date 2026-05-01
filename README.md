# Microservices Logging System

##  Overview
This project implements a centralized logging system using Spring Boot and Kafka.

##  Architecture
Microservices → Kafka → Log Service → PostgreSQL

##  Tech Stack
- Spring Boot
- Apache Kafka
- PostgreSQL
- API Gateway

##  Features
- Centralized logging
- Trace ID tracking
- Asynchronous communication
- Microservices architecture

##  API Flow

1. Client sends request to API Gateway
2. Gateway routes request to respective microservice
3. Service processes request
4. Logs are sent to Log Service via Kafka
5. Response is returned back to client

##  Kafka Flow

1. Microservices produce events (e.g., Order Created)
2. Events are sent to Kafka topics
3. Log Service consumes events from Kafka
4. Logs are stored in PostgreSQL
5. Helps in centralized logging and tracing    

##  Author
Muhammad Ahmad
