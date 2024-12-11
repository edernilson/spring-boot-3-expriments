# Distributed Scheduling with PostgreSQL

This is a example of distributed scheduling with PostgreSQL, based on the article [Distributed Scheduling with PostgreSQL](https://speakerdeck.com/rponte/distributed-scheduling-with-spring-boot-the-challenges-and-pitfalls-of-implementing-a-background-job/).

## Stack

* Spring Boot 3.4.0
* Spring Web, Data Jpa
* Gatling 3.11.4
* Java 17

## Running the application

1. Running application

```shell
mvn spring-boot:run
```

2. Running the Gatling load test

```shell
mvn gatling:test
```

## Reference Documentation

For further reference, please consider the following sections:

* [Distributed Scheduling with PostgreSQL](https://speakerdeck.com/rponte/distributed-scheduling-with-spring-boot-the-challenges-and-pitfalls-of-implementing-a-background-job/)
* [Gatling](https://gatling.io/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)


## License

MIT