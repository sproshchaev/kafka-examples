# Shared Model

Общий модуль с доменными объектами для всех примеров работы с Apache Kafka. Содержит базовый класс `Person` и фабрику 
для создания тестовых объектов, которые используются во всех остальных модулях для обеспечения консистентности данных.

## 🏗️ Архитектура

```
shared-model/
├── src/main/java/com/prosoft/
│   ├── model/
│   │   └── Person.java              # Основной доменный объект
│   └── factory/
│       └── TestPersonFactory.java   # Фабрика для создания тестовых объектов
└── build.gradle                     # Конфигурация сборки
```

### Класс `Person`
- Поля: id, name, age, email, createdAt  
- Аннотации Lombok (@Data, @Builder, @NoArgsConstructor, @AllArgsConstructor)  
- Чистая модель данных без бизнес-логики  

### Фабрики
- `TestPersonFactory` - создание тестовых объектов с последовательными ID

## 🚀 Запуск

Модуль является библиотечным и не требует отдельного запуска. Подключается как зависимость в другие модули:

```gradle
dependencies {
    implementation project(':shared-model')
}
```

## 🧪 Тестирование

Модуль включает фабрики для создания тестовых данных:

### Примеры использования:

```java
// Создание тестовой персоны
TestPersonFactory testFactory = new TestPersonFactory();
Person testPerson = testFactory.createTestPerson();

// Очистка счетчиков тестовой фабрики
testFactory.clearCounters();
```

### Особенности тестовой фабрики:
- Генерирует последовательные ID в формате: `yyyyMMddHHmmss[-номер]` 
- Создает случайный возраст от 18 до 65 лет  
- Автоматически заполняет имя и email на основе ID   
- Поддерживает внедрение зависимостей для тестирования (Clock, Random)  
