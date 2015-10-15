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

    @HystrixCommand(groupKey = "actors", commandKey = "getActor", fallbackMethod = "defaultActor")
    public Actor get(String id) {
        return actorRestClient.get(id);
    }

    public Actor defaultActor(String id) {
        return new Actor("Actor not found");
    }
}
