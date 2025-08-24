# kafka-platform

Все эти конфигурации docker-compose настроены и проверены: 
[docker-compose.yml](docker-compose.yml)
[docker-compose2.yml](docker-compose2.yml)
[docker-compose-kraft1.yml](docker-compose-kraft1.yml)
[docker-compose-kraft1-4.yml](docker-compose-kraft1-4.yml)
[docker-compose-kraft3.yml](docker-compose-kraft3.yml)
[docker-compose-kraft3-2.yml](docker-compose-kraft3-2.yml)
[docker-compose-kraft3-3.yml](docker-compose-kraft3-3.yml)
[docker-compose-kraft3-4.yml](docker-compose-kraft3-4.yml)

(в каждом указан в комментариях)

Для обеспечения единообразного подключения внешних приложений к кластеру Kafka нужно стандартизировать следующие параметры:

## Общие рекомендации для всех конфигураций:

### 1. Бутстрап сервер (Bootstrap Server)
**Внешний адрес:** `localhost:9093` (для всех конфигураций) или `localhost:9091, localhost:9092, localhost:9093`

### 2. Регистр схем (Schema Registry)
**Внешний адрес:** `localhost:8081`

### 3. REST API (Kafka REST Proxy)
**Внешний адрес:** `localhost:8082` 

## Анализ каждого файла:

### Файл №1 docker-compose.yml (Минимальная конфигурация с Zookeeper)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ kafdrop - протестирован на http://localhost:9000/
- ❌ Регистр схем: отсутствует
- ❌ REST API: отсутствует
- ✅ volume именованы!

### Файл №2 docker-compose2.yml (Kafka for Developers)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081`(стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ REST API: `localhost:8082`
- ✅ kafdrop - протестирован на http://localhost:9000/
- ❌ volume не именованы!

### Файл №3 docker-compose-kraft1.yml (KRaft - single node)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ kafdrop - протестирован на http://localhost:9000/
- ❌ Регистр схем: отсутствует
- ❌ REST API: отсутствует
- ❌ volume не именованы!

### Файл №4 docker-compose-kraft1-4.yml (KRaft - 1 controller + 1 broker)
- ✅ Бутстрап: `localhost:9093` - протестирован webinar-01 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"} 
- ✅ REST API: `localhost:8082`
- ✅ kafka-ui - протестирован на http://localhost:8088/
- ❌ volume не именованы!

### Файл №5 docker-compose-kraft3.yml (KRaft - 3 controller + 3 broker)
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"
- ✅ kafdrop - протестирован на http://localhost:9000/
- ❌ Регистр схем: отсутствует
- ❌ REST API: отсутствует
- ❌ volume не именованы!

### Файл №6 docker-compose-kraft3-2.yml (KRaft - 3 controller + 3 broker + Schema Registry)
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ kafdrop - протестирован на http://localhost:9000/
- ❌ REST API: отсутствует
- ❌ volume не именованы!

### Файл №7 docker-compose-kraft3-3.yml (KRaft - 3 controller + 3 broker + Schema Registry + Kafka UI)
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ kafka-ui - протестирован на http://localhost:8088/
- ❌ REST API: отсутствует
- ❌ volume не именованы!

### Файл №8 docker-compose-kraft3-4.yml (Полная конфигурация) 
- ✅ Бутстрап: `localhost:9091, localhost:9092, localhost:9093` - протестирован webinar-02 "producer service/consumer service"
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ REST API: `localhost:8082`
- ✅ kafka-ui - протестирован на http://localhost:8088/
- ❌ volume не именованы!

### Файл №9 docker-compose-kraft3-5.yml (Полная конфигурация) - см в заголовке `Проблема`
- ✅ Бутстрап: `localhost:29092` - через broker-1 
- ✅ Регистр схем: `localhost:8081` (стандартный порт), проверен http://localhost:8081/config -> {"compatibilityLevel":"BACKWARD"}
- ✅ REST API: `localhost:8082`
- ✅ kafka-ui - протестирован на http://localhost:8088/
- ❌ volume не именованы!


## Рекомендуемые изменения для стандартизации:
После этих изменений внешние приложения смогут подключаться единообразно:
- Бутстрап сервер: `localhost:9093` или `localhost:9091, localhost:9092, localhost:9093` 
- Регистр схем: `localhost:8081`
- REST API: `localhost:8082`