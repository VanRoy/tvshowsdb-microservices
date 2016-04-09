package com.github.vanroy.tvshowsdb.repository;

import com.github.vanroy.tvshowsdb.event.Changes;
import com.github.vanroy.tvshowsdb.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Actor event handlers.
 * @author Julien Roy
 */
@Component
@RepositoryEventHandler(Actor.class)
public class ActorEventHandler {

    @Autowired
    public Changes changes;

    @HandleAfterCreate
    @HandleAfterSave
    public void handleActorChange(Actor actor) {
        changes.actorChanges().send(MessageBuilder.withPayload(actor).build());
    }
}
