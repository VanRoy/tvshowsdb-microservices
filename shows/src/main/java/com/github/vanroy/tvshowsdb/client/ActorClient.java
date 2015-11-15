package com.github.vanroy.tvshowsdb.client;

import com.github.vanroy.tvshowsdb.model.Actor;
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

    public Actor loadActorInfo(Actor actor) {
        return actorRestClient.get(actor.getId());
    }

}
