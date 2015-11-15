# TV Shows DB

Application de demonstration d'une architecture microservices avec Spring Cloud Netflix

Cette application met en oeuvre les elements suivants :

- Service Discovery ( Eureka )
- IPC ( Feign )
- Client Side Load Balancer ( Ribbon )
- Circuit Breaker ( Hystrix )
- Data Streams ( Spring Cloud Stream )
- API Gateway ( Zuul )

## Instructions

### Branches

| Branche  | Fonctionnalité                          |
| -------- | --------                                |
| master   | Toutes les fonctionnalités              |
| init     | Base de travail vide                    |
| eureka   | Service discovery avec Eureka           |
| feign    | IPC avec Feign + Ribbon                 |

### Prérequis

Cette démo requiert un JDK 8 et Docker.

### Lancement de l'application
```
# Compiler et lancer : supervisor, gateway, 1 show, 2 actors, 1 review
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
