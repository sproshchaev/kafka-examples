# kafka-examples


```txt
kafka-examples/
├── common/                          # Общие компоненты и модели для всех модулей
├── 01-producer-basic/               # Базовый продюсер Kafka с REST API
├── 02-consumer-basic/               # Базовый консьюмер Kafka с listener и REST API
├── 03-producer-advanced/            # Продвинутый продюсер с асинхронной отправкой и транзакциями
├── 04-consumer-advanced/            # Продвинутый консьюмер с batch processing и concurrency
├── 05-partitioning/                 # Работа с партиционированием и кастомными партиционерами
├── 06-serialization/                # Различные форматы сериализации (JSON, Avro, Protobuf)
├── 07-error-handling/               # Обработка ошибок, Dead Letter Queue, retry механизмы
├── 08-batch-processing/             # Пакетная обработка сообщений Kafka
├── 09-transactions/                 # Транзакционная работа с Kafka
├── 10-kafka-streams-basic/          # Базовые потоковые операции Kafka Streams
├── 11-kafka-streams-aggregations/   # Агрегации и группировки в Kafka Streams
├── 12-kafka-streams-joins/          # Join операции в Kafka Streams
├── 13-kafka-streams-windowing/      # Оконные операции в Kafka Streams
├── 14-metrics-monitoring/           # Мониторинг метрик Kafka и приложения
├── 15-health-checks/                # Health checks для Kafka компонентов
├── 16-retry-policies/               # Политики повторных попыток и экспоненциальная отсрочка
├── 17-event-sourcing/               # Паттерн Event Sourcing с Kafka
├── 18-cqrs-saga/                    # CQRS и Saga паттерны с оркестрацией
└── infrastructure/                  # Инфраструктурные компоненты и конфигурации
```

Развернутый вариант

## 📁 **Структура проекта kafka-spring-examples с содержимым модулей**

```
kafka-examples/
├── build.gradle
├── settings.gradle
├── gradle.properties
├── README.md
├── gradle/
│   └── wrapper/
├── common/
│   ├── build.gradle
│   ├── README.md
│   └── src/main/java/com/example/kafka/common/
│       ├── model/
│       │   ├── Person.java
│       │   └── PersonEvent.java
│       ├── serializer/
│       │   ├── PersonSerializer.java
│       │   └── PersonDeserializer.java
│       ├── config/
│       │   └── KafkaCommonConfig.java
│       └── util/
│           └── Constants.java
├── 01-producer-basic/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/producer/basic/
│       ├── ProducerBasicApplication.java
│       ├── config/
│       │   └── KafkaProducerConfig.java
│       ├── controller/
│       │   └── PersonProducerController.java
│       ├── service/
│       │   └── PersonProducerService.java
│       ├── dto/
│       │   └── PersonRequest.java
│       └── exception/
│           └── ProducerException.java
├── 02-consumer-basic/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/consumer/basic/
│       ├── ConsumerBasicApplication.java
│       ├── config/
│       │   └── KafkaConsumerConfig.java
│       ├── controller/
│       │   └── ConsumerStatusController.java
│       ├── listener/
│       │   └── PersonMessageListener.java
│       ├── service/
│       │   └── PersonConsumerService.java
│       └── handler/
│           └── PersonMessageHandler.java
├── 03-producer-advanced/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/producer/advanced/
│       ├── ProducerAdvancedApplication.java
│       ├── config/
│       │   ├── AdvancedKafkaProducerConfig.java
│       │   └── AsyncProducerConfig.java
│       ├── controller/
│       │   └── AdvancedProducerController.java
│       ├── service/
│       │   ├── AsyncPersonProducerService.java
│       │   └── TransactionalPersonProducerService.java
│       ├── partitioner/
│       │   └── CustomPersonPartitioner.java
│       ├── dto/
│       │   └── AdvancedPersonRequest.java
│       └── util/
│           └── ProducerMetrics.java
├── 04-consumer-advanced/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/consumer/advanced/
│       ├── ConsumerAdvancedApplication.java
│       ├── config/
│       │   └── AdvancedKafkaConsumerConfig.java
│       ├── controller/
│       │   └── AdvancedConsumerController.java
│       ├── listener/
│       │   ├── BatchPersonListener.java
│       │   └── ConcurrentPersonListener.java
│       ├── service/
│       │   └── AdvancedPersonConsumerService.java
│       ├── error/
│       │   ├── DeadLetterQueueHandler.java
│       │   └── CustomErrorHandler.java
│       └── processor/
│           └── PersonBatchProcessor.java
├── 05-partitioning/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/partitioning/
│       ├── PartitioningApplication.java
│       ├── config/
│       │   └── PartitioningConfig.java
│       ├── controller/
│       │   └── PartitioningTestController.java
│       ├── partitioner/
│       │   ├── PersonKeyPartitioner.java
│       │   └── CustomHashPartitioner.java
│       ├── service/
│       │   └── PartitioningTestService.java
│       └── dto/
│           └── PartitioningRequest.java
├── 06-serialization/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/serialization/
│       ├── SerializationApplication.java
│       ├── config/
│       │   └── SerializationConfig.java
│       ├── controller/
│       │   └── SerializationTestController.java
│       ├── serializer/
│       │   ├── JsonSerializer.java
│       │   ├── AvroPersonSerializer.java
│       │   └── ProtobufPersonSerializer.java
│       ├── deserializer/
│       │   ├── JsonPersonDeserializer.java
│       │   ├── AvroPersonDeserializer.java
│       │   └── ProtobufPersonDeserializer.java
│       └── dto/
│           └── SerializationTestRequest.java
├── 07-error-handling/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/error/
│       ├── ErrorHandlingApplication.java
│       ├── config/
│       │   └── ErrorHandlingConfig.java
│       ├── controller/
│       │   └── ErrorHandlingTestController.java
│       ├── handler/
│       │   ├── GlobalErrorHandler.java
│       │   ├── DeadLetterQueueHandler.java
│       │   └── RetryableErrorHandler.java
│       ├── service/
│       │   └── ErrorRecoveryService.java
│       ├── retry/
│       │   ├── RetryTemplateConfig.java
│       │   └── RetryPolicy.java
│       └── exception/
│           ├── RecoverableException.java
│           └── NonRecoverableException.java
├── 08-batch-processing/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/batch/
│       ├── BatchProcessingApplication.java
│       ├── config/
│       │   └── BatchConsumerConfig.java
│       ├── controller/
│       │   └── BatchProcessingController.java
│       ├── listener/
│       │   └── BatchPersonListener.java
│       ├── processor/
│       │   ├── PersonBatchProcessor.java
│       │   └── BatchAggregator.java
│       ├── service/
│       │   └── BatchProcessingService.java
│       └── dto/
│           └── BatchTestRequest.java
├── 09-transactions/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/transactions/
│       ├── TransactionsApplication.java
│       ├── config/
│       │   └── TransactionalKafkaConfig.java
│       ├── controller/
│       │   └── TransactionalPersonController.java
│       ├── service/
│       │   ├── TransactionalPersonService.java
│       │   └── ReliablePersonProducer.java
│       └── dto/
│           └── TransactionalPersonRequest.java
├── 10-kafka-streams-basic/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/streams/basic/
│       ├── StreamsBasicApplication.java
│       ├── config/
│       │   └── BasicStreamsConfig.java
│       ├── controller/
│       │   └── StreamsTestController.java
│       ├── topology/
│       │   └── PersonStreamTopology.java
│       ├── processor/
│       │   ├── PersonFilterProcessor.java
│       │   └── PersonTransformProcessor.java
│       └── service/
│           └── StreamProcessingService.java
├── 11-kafka-streams-aggregations/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/streams/aggregations/
│       ├── StreamsAggregationsApplication.java
│       ├── config/
│       │   └── AggregationStreamsConfig.java
│       ├── controller/
│       │   └── AggregationController.java
│       ├── topology/
│       │   └── AggregationTopology.java
│       ├── aggregator/
│       │   ├── PersonCountAggregator.java
│       │   └── PersonAgeAggregator.java
│       └── service/
│           └── AggregationService.java
├── 12-kafka-streams-joins/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/streams/joins/
│       ├── StreamsJoinsApplication.java
│       ├── config/
│       │   └── JoinStreamsConfig.java
│       ├── controller/
│       │   └── JoinTestController.java
│       ├── topology/
│       │   └── JoinTopology.java
│       ├── joiner/
│       │   ├── PersonStreamTableJoiner.java
│       │   └── PersonStreamStreamJoiner.java
│       └── service/
│           └── JoinProcessingService.java
├── 13-kafka-streams-windowing/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/streams/windowing/
│       ├── StreamsWindowingApplication.java
│       ├── config/
│       │   └── WindowingStreamsConfig.java
│       ├── controller/
│       │   └── WindowingTestController.java
│       ├── topology/
│       │   └── WindowingTopology.java
│       ├── window/
│       │   ├── TumblingWindowProcessor.java
│       │   └── SlidingWindowProcessor.java
│       └── service/
│           └── WindowingService.java
├── 14-metrics-monitoring/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/metrics/
│       ├── MetricsApplication.java
│       ├── config/
│       │   └── MetricsConfig.java
│       ├── controller/
│       │   └── MetricsController.java
│       ├── reporter/
│       │   ├── KafkaMetricsReporter.java
│       │   └── CustomMetricsReporter.java
│       ├── service/
│       │   └── MetricsCollectionService.java
│       └── dto/
│           └── MetricsResponse.java
├── 15-health-checks/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/health/
│       ├── HealthApplication.java
│       ├── config/
│       │   └── HealthConfig.java
│       ├── controller/
│       │   └── HealthCheckController.java
│       ├── indicator/
│       │   └── KafkaHealthIndicator.java
│       └── service/
│           └── HealthMonitoringService.java
├── 16-retry-policies/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/retry/
│       ├── RetryApplication.java
│       ├── config/
│       │   └── RetryConfig.java
│       ├── controller/
│       │   └── RetryTestController.java
│       ├── policy/
│       │   ├── ExponentialBackoffRetryPolicy.java
│       │   ├── FixedDelayRetryPolicy.java
│       │   └── CustomRetryPolicy.java
│       ├── template/
│       │   └── RetryTemplateService.java
│       └── service/
│           └── RetryablePersonService.java
├── 17-event-sourcing/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/eventsourcing/
│       ├── EventSourcingApplication.java
│       ├── config/
│       │   └── EventSourcingConfig.java
│       ├── controller/
│       │   └── EventSourcingController.java
│       ├── event/
│       │   ├── PersonCreatedEvent.java
│       │   ├── PersonUpdatedEvent.java
│       │   ├── PersonDeletedEvent.java
│       │   └── DomainEvent.java
│       ├── store/
│       │   └── EventStoreService.java
│       ├── service/
│       │   └── PersonEventSourcingService.java
│       ├── aggregate/
│       │   └── PersonAggregate.java
│       └── dto/
│           └── EventSourcingRequest.java
├── 18-cqrs-saga/
│   ├── build.gradle
│   ├── README.md
│   ├── docker-compose.yml
│   └── src/main/java/com/example/kafka/cqrs/
│       ├── CqrsSagaApplication.java
│       ├── config/
│       │   └── CqrsConfig.java
│       ├── controller/
│       │   ├── CommandController.java
│       │   └── QueryController.java
│       ├── command/
│       │   ├── service/
│       │   │   └── PersonCommandService.java
│       │   └── handler/
│       │       └── PersonCommandHandler.java
│       ├── query/
│       │   ├── service/
│       │   │   └── PersonQueryService.java
│       │   └── handler/
│       │       └── PersonQueryHandler.java
│       ├── saga/
│       │   ├── orchestrator/
│       │   │   └── PersonSagaOrchestrator.java
│       │   ├── participant/
│       │   │   └── PersonSagaParticipant.java
│       │   └── state/
│       │       └── SagaState.java
│       └── dto/
│           ├── PersonCommandRequest.java
│           └── PersonQueryRequest.java
└── infrastructure/
    ├── docker-compose.full.yml
    ├── kafka-cluster/
    │   ├── docker-compose.cluster.yml
    │   └── scripts/
    ├── monitoring/
    │   ├── docker-compose.monitoring.yml
    │   ├── prometheus.yml
    │   └── grafana/
    └── schemas/
        └── avro/
```