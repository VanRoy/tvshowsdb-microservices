package com.github.vanroy.tvshowsdb.client;

import com.github.vanroy.tvshowsdb.model.Actor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Actors client with fallback.
 * @author Julien Roy
 */
@Component
public class ActorClient {

    @Autowired
    ActorRestClient actorRestClient;

    @HystrixCommand(fallbackMethod = "actorWithoutInfo")
    public Actor loadActorInfo(Actor actor) {
        return actorRestClient.get(actor.getId());
    }

    public Actor actorWithoutInfo(Actor actor) {
        return actor;
    }
}
