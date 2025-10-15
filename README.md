## НЕТОЛОГИЯ
Хранение данных и организация безопасности: ORM, Hibernate (минусы и плюсы), Entity Lifecycle, Embedding, Relationships

## Задание
1. Написать приложение для работы с БД, используя средства Spring по конфигурации и работе с Hibernate, адаптировав таблицы из задания
   [«Таблица пользователей»](https://github.com/netology-code/jd-homeworks/blob/master/sql-basic/task/README.md).
2. Переписать приложение из [задания по JDBC](https://github.com/netology-code/jd-homeworks/blob/master/jdbc/task1/README.md) на Hibernate.
   - Нужно написать две Entity, соответствующие двум таблицам из задания. Учтите, что вам надо верно выбрать логику отношений этих Entity: OneToOne, OneToMany, ManyToOne, ManyToMany.
   - Перепишите репозиторий, чтобы он работал с EntityManager, а не через NamedParameterJdbcTemplate.
3. Адаптировать логику работы задания [«Слой DAO c Hibernate»](https://github.com/netology-code/jd-homeworks/blob/master/hibernate/task1/README.md) так,
   чтобы ваше приложение работало одновременно и с миграциями, и с Hibernate. Не важно, выберете вы Flyway или Liquibase.
