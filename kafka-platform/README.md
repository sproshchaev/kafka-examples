# kafka-platform

## Содержание конфигураций:

См:  
##### ZooKeeper
`1.`  Один брокер с ZooKeeper, Kafdrop: [docker-compose.zk-min.yml](docker-compose.zk-min.yml)  
`1.1` Один брокер с ZooKeeper, Kafka UI: [docker-compose.zk-min.kafka-ui.yml](docker-compose.zk-min.kafka-ui.yml)  

`2.`  Один брокер с ZooKeeper, Schema Registry (+ui), Kafka REST, Kafdrop: [docker-compose.zk-dev-full.yml](docker-compose.zk-dev-full.yml)  
`2.1` Один брокер с ZooKeeper, Schema Registry (+ui), Kafka REST, Kafka UI: [docker-compose.zk-dev-full.kafka-ui.yml](docker-compose.zk-dev-full.kafka-ui.yml)

##### KRaft
`3.`  Один брокер с контроллером KRaft, Kafdrop: [docker-compose.kraft-1node.yml](docker-compose.kraft-1node.yml)  
`3.1` Один брокер с контроллером KRaft, Kafka UI: [docker-compose.kraft-1node.kafka-ui.yml](docker-compose.kraft-1node.kafka-ui.yml)  

`4.`  Один брокер с контроллером KRaft, Schema Registry (+ui), Kafka REST, Kafka UI: [docker-compose.kraft-1c1b-full.yml](docker-compose.kraft-1c1b-full.yml)  
`4.1` Один брокер с контроллером KRaft, Schema Registry (+ui), Kafka REST, Kafdrop: [docker-compose.kraft-1c1b-full.kafdrop.yml](docker-compose.kraft-1c1b-full.kafdrop.yml)   


| №   | Имя файла                                                                                        | bootstrap.servers                   | ZooKeeper<br/>KRaft | Schema Registry | Kafka REST API | Kafdrop(:9000)<br/>Kafka UI(:8088) | Volume names |
|:----|:-------------------------------------------------------------------------------------------------|:------------------------------------|:--------------------|:----------------|:---------------|:-----------------------------------|:-------------|
| 1   | [docker-compose.zk-min.yml](docker-compose.zk-min.yml)                      | `localhost:9093`                    | ZooKeeper           | ❌              | ❌             | `http://localhost:9000`            | ✅           |
| 1.1 | [docker-compose.zk-min.kafka-ui.yml](docker-compose.zk-min.kafka-ui.yml)             | `localhost:9093`                    | ZooKeeper           | ❌              | ❌             | `http://localhost:9000`            | ✅           |
| 2   | [docker-compose.zk-dev-full.yml](docker-compose.zk-dev-full.yml)                 | `localhost:9093`                    | ZooKeeper           | `:8081`/`:8001` | `:8082`        | `http://localhost:9000`            | ❌           |
| 2.1 | [docker-compose.zk-dev-full.kafka-ui.yml](docker-compose.zk-dev-full.kafka-ui.yml)        | `localhost:9093`                    | ZooKeeper           | `:8081`/`:8001` | `:8082`        | `http://localhost:8088`            | ❌           |
| 3   | [docker-compose.kraft-1node.yml](docker-compose.kraft-1node.yml)                 | `localhost:9093`                    | KRaft               | ❌              | ❌             | `http://localhost:9000`            | ❌           |
| 3.1 | [docker-compose.kraft-1node.kafka-ui.yml](docker-compose.kraft-1node.kafka-ui.yml)        | `localhost:9093`                    | KRaft               | ❌              | ❌             | `http://localhost:8088`            | ❌           |
| 4   | [docker-compose.kraft-1c1b-full.yml](docker-compose.kraft-1c1b-full.yml)             | `localhost:9093`                    | KRaft               | `:8081`/`:8001` | `:8082`        | `http://localhost:8088`            | ❌           |
| 4.1 | [docker-compose.kraft-1c1b-full.kafdrop.yml](docker-compose.kraft-1c1b-full.kafdrop.yml)     | `localhost:9093`                    | KRaft               | `:8081`/`:8001` | `:8082`        | `http://localhost:9000`            | ❌           |
| 5   | [docker-compose.kraft-3c3b-min.yml](docker-compose.kraft-3c3b-min.yml)              | `localhost:9091,:9092,:9093`        | KRaft               | ❌              | ❌             | `http://localhost:9000`            | ❌           |
| 6   | [docker-compose.kraft-3c3b-sr.yml](docker-compose.kraft-3c3b-sr.yml)               | `localhost:9091,:9092,:9093`        | KRaft               | `:8081`/`:8001` | ❌             | `http://localhost:9000`            | ❌           |
| 7   | [docker-compose.kraft-3c3b-sr-ui.yml](docker-compose.kraft-3c3b-sr-ui.yml)            | `localhost:9091,:9092,:9093`        | KRaft               | `:8081`/`:8001` | ❌             | `http://localhost:8088`            | ❌           |
| 8   | [docker-compose.kraft-3c3b-complete.yml](docker-compose.kraft-3c3b-complete.yml)         | `localhost:9091,:9092,:9093`        | KRaft               | `:8081`         | `:8082`        | `http://localhost:8088`            | ❌           |
| 9   | [docker-compose.kraft-3c3b-broken-bootstrap.yml](docker-compose.kraft-3c3b-broken-bootstrap.yml) | `localhost:29092` (**отличается!**) | KRaft               | `:8081`         | `:8082`        | `http://localhost:8088`            | ❌           |

**Легенда:**  
*   ✅ - Функция присутствует и работает согласно описанию.  
*   ❌ - Функция отсутствует или не настроена.  
*   **Жирный текст** - Отличие от стандартизированного значения.  

### Файл №1 ocker-compose.zk-min.yml (Минимальная конфигурация с Zookeeper) 
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"  
- ✅ kafdrop - протестирован на http://localhost:9000/  
- ❌ Регистр схем: отсутствует  
- ❌ REST API: отсутствует  
- ✅ volume именованы!  
_(ex. docker-compose.yml)_  

### Файл №1.1 docker-compose.zk-min.kafka-ui.yml (Минимальная конфигурация с Zookeeper)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ kafka-ui - протестирован на http://localhost:8088/
- ❌ Регистр схем: отсутствует
- ❌ REST API: отсутствует
- ✅ volume именованы!  
  _(ex. docker-compose.yml)_

### Файл №2 docker-compose.zk-dev-full.yml (Kafka for Developers)  
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"  
- ✅ Регистр схем: `localhost:8081`(стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}  
- ✅ schema-registry-ui: проверен http://localhost:8001
- ✅ REST API: `localhost:8082` 
- ✅ kafdrop - протестирован на http://localhost:9000/   
- ❌ volume не именованы!  
_(ex. docker-compose2.yml)_  

### Файл №2.1 docker-compose.zk-dev-full.yml (Kafka for Developers)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081`(стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ schema-registry-ui: проверен http://localhost:8001  
- ✅ REST API: `localhost:8082`
- ✅ kafka-ui - протестирован на http://localhost:8088/
- ❌ volume не именованы!

### Файл №3 docker-compose.kraft-1node.yml (KRaft - single node) 
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"  
- ✅ kafdrop - протестирован на http://localhost:9000/  
- ❌ Регистр схем: отсутствует  
- ❌ REST API: отсутствует  
- ❌ volume не именованы!  
_(ex. docker-compose-kraft1.yml)_  

### Файл №3.1 docker-compose.kraft-1node.kafka-ui.yml (KRaft - single node)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ kafka-ui - протестирован на http://localhost:8088/  
- ❌ Регистр схем: отсутствует
- ❌ REST API: отсутствует
- ❌ volume не именованы!  

### Файл №4 docker-compose.kraft-1c1b-full.yml (KRaft - 1 controller + 1 broker)  
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"  
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}   
- ✅ schema-registry-ui: проверен http://localhost:8001  
- ✅ REST API: `localhost:8082` 
- ✅ kafka-ui - протестирован на http://localhost:8088/  
- ❌ volume не именованы!   
_(ex. docker-compose-kraft1-4.yml)_  

### Файл №4.1 docker-compose.kraft-1c1b-full.kafdrop.yml (KRaft - 1 controller + 1 broker)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ schema-registry-ui: проверен http://localhost:8001  
- ✅ REST API: `localhost:8082`
- ✅ kafdrop - протестирован на http://localhost:9000/
- ❌ volume не именованы!

### Файл №5 docker-compose.kraft-3c3b-min.yml (KRaft - 3 controller + 3 broker) 
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"  
- ✅ kafdrop - протестирован на http://localhost:9000/  
- ❌ Регистр схем: отсутствует  
- ❌ REST API: отсутствует  
- ❌ volume не именованы!  
_(ex. docker-compose-kraft3.yml)_  

### Файл №6 docker-compose.kraft-3c3b-sr.yml (KRaft - 3 controller + 3 broker + Schema Registry)  
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"  
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}  
- ✅ schema-registry-ui: проверен http://localhost:8001  
- ✅ kafdrop - протестирован на http://localhost:9000/  
- ❌ REST API: отсутствует  
- ❌ volume не именованы!  
_(ex. docker-compose-kraft3-2.yml)_  

### Файл №7 docker-compose.kraft-3c3b-sr-ui.yml (KRaft - 3 controller + 3 broker + Schema Registry + Kafka UI)  
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"  
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}  
- ✅ schema-registry-ui: проверен http://localhost:8001  
- ✅ kafka-ui - протестирован на http://localhost:8088/  
- ❌ REST API: отсутствует  
- ❌ volume не именованы!  
_(ex. docker-compose-kraft3-3.yml)_

### Файл №8 docker-compose.kraft-3c3b-complete.yml (Полная конфигурация)  
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"  
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}  
- ✅ REST API: `localhost:8082`  
- ✅ kafka-ui - протестирован на http://localhost:8088/  
- ❌ volume не именованы!  
_(ex. docker-compose-kraft3-4.yml)_  

### Файл №9 docker-compose.kraft-3c3b-broken-bootstrap.yml (Полная конфигурация) - см в заголовке `Проблема`   
- ✅ Бутстрап: `localhost:29092` - через broker-1  
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}  
- ✅ REST API: `localhost:8082`  
- ✅ kafka-ui - протестирован на http://localhost:8088/  
- ❌ volume не именованы!  
_(ex. docker-compose-kraft3-5.yml)_  