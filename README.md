Monitor Sensors Application

Это CRUD приложение для управления датчиками. Оно позволяет добавлять, редактировать, удалять и просматривать информацию о датчиках, а также выполнять поиск по их характеристикам.


Стек технологий

Java 17
Spring Boot
Spring Data JPA
Spring Security
Hibernate
PostgreSQL (или другая реляционная БД)
Liquibase (для миграций БД)
Swagger (для документации API)
Docker (для контейнеризации приложения)


API Endpoints
Датчики

GET /api/sensors: Получить список всех датчиков.

GET /api/sensors/{id}: Получить датчик по ID.

POST /api/sensors: Создать новый датчик.

PUT /api/sensors/{id}: Обновить датчик по ID.

DELETE /api/sensors/{id}: Удалить датчик по ID.

GET /api/sensors/search: Поиск датчиков по имени или модели.

