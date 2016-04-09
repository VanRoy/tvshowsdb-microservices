package com.github.vanroy.tvshowsdb.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by julien on 08/04/2016.
 */
public interface Changes {

    String ACTOR_CHANGES = "actorChanges";

    @Input(ACTOR_CHANGES)
    SubscribableChannel actorChanges();

}
