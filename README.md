# kafka-examples

Первый вариант на 18 модулей:  
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
└── kafka-platform/                  # Инфраструктурные компоненты и конфигурации
```

Второй вариант на 26 модулей:  
```
kafka-examples/  
├── 01-basic-producer/                   # Базовый продюсер Kafka  
├── 02-basic-consumer/                   # Базовый консьюмер Kafka  
├── 03-topic-creation/                   # Создание топиков Kafka  
├── 04-json-serialization/               # Сериализация сообщений в JSON  
├── 05-partitioning/                     # Работа с партициями  
├── 06-key-based-routing/                # Роутинг сообщений по ключу  
├── 07-error-handling/                   # Обработка ошибок в консьюмере  
├── 08-retry-mechanism/                  # Механизм повторных попыток  
├── 09-kafka-streams/                    # Потоковая обработка Kafka Streams  
├── 10-kafka-transaction/                # Транзакции в Kafka  
├── 11-schema-registry/                  # Работа со Schema Registry и Avro  
├── 12-batch-processing/                 # Пакетная обработка сообщений  
├── 13-manual-offset-commit/             # Ручное управление оффсетами  
├── 14-filtering-messages/               # Фильтрация сообщений  
├── 15-message-enrichment/               # Обогащение сообщений  
├── 16-kafka-headers/                    # Работа с заголовками сообщений  
├── 17-multi-topic-routing/              # Маршрутизация по нескольким топикам  
├── 18-backpressure-handling/            # Обработка обратного давления  
├── 19-idempotent-producer/              # Идемпотентный продюсер  
├── 20-consumer-groups/                  # Работа с группами консьюмеров  
├── 21-kafka-connect-example/            # Пример использования Kafka Connect  
├── 22-kafka-metrics-monitoring/         # Мониторинг метрик Kafka  
├── 23-message-deduplication/            # Дедупликация сообщений  
├── 24-priority-messaging/               # Приоритетная обработка сообщений  
├── 25-kafka-security-sasl/              # Безопасность Kafka через SASL  
└── 26-event-sourcing-pattern/           # Паттерн Event Sourcing
```

