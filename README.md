# TV Shows DB

Application de demonstration d'une architecture microservices avec Spring Cloud Netflix.

Les slides de la présentation sont sur [slideshare](http://fr.slideshare.net/3k1n0/se-lancer-dans-laventure-microservices-avec-spring-cloud-julien-roy).

Cette application met en oeuvre les elements suivants :

- Service Discovery ( Eureka )
- IPC ( Feign )
- Client Side Load Balancer ( Ribbon )
- Circuit Breaker ( Hystrix )
- API Gateway ( Zuul )

## Instructions

### Prérequis

Cette démo necessite un JDK 8 ainsi que Gradle 2.4.

### Lancement de l'application
```
# Compiler et lancer : supervisor, gateway, 1 show, 2 actors, 1 review
gradle build
./startup.sh -a 2
tail -f logs/show.out logs/actor-2.out
```

### Urls

| Service     | Url                                 |
| ----------- | --------                            |
| Dashboard   | http://localhost:8001               |
| Gateway     | http://localhost:8002               |
| UI          | http://localhost:8080               |
| Show        | http://localhost:8011               |
| Actor       | http://localhost:8021               |
| Review      | http://localhost:8031               |
