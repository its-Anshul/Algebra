# Algebra Service

This is a Java / Maven / Spring Boot (version 1.5.6) application that can be used to evaluate a mathematical expression and also for retrieving the most used mathematical operator by a user.

## How to Run 

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvnw clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar target/algebra_services-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run
```
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2021-03-17 09:06:44.249  INFO 11104 --- [           main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
2021-03-17 09:06:44.280  INFO 11104 --- [           main] c.b.a.AlgebraServicesApplication         : Started AlgebraServicesApplication in 10.996 seconds (JVM running for 13.033)
...
webServerFactoryCustomizerBeanPostProcessor
websocketServletWebServerCustomizer
welcomePageHandlerMapping
```

Here are some endpoints you can call:

### Evaluate a mathematical expression

```
GET http://localhost:8080/api/v1/calculate
Request Body :- UserId,equation
```

### Get most used mathematical operator by user

```
GET http://localhost:8080/api/v1/userchoice
Request Body :- UserId
```

### To view Swagger 2 API docs

Run the server and browse to http://localhost:8080/swagger-ui.html


### To view your H2 in-memory datbase

The 'test' profile runs on H2 in-memory database. To view and query the database you can browse to http://localhost:8080/h2-ui. Default username is 'sa' with a blank password.
