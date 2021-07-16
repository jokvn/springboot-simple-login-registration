# Simple login and registration with Spring Boot

Simple Project for authenticating and registrating users.

#### Dependencies used:
* Spring Data JPA
* Spring Security
* Spring Web
* Lombok

I used docker for my mariaDB service and included the `docker-compose` inside `src/main/java/io/jokev/springsimpleloginregistration/docker`

Start the database:
```
$ cd src/main/java/io/jokev/springsimpleloginregistration/docker
$ docker-compose up
```

Stop the database:
```
$ cd src/main/java/io/jokev/springsimpleloginregistration/docker
$ docker-compose down
```
