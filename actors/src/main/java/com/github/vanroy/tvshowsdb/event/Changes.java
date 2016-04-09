package com.github.vanroy.tvshowsdb.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by julien on 08/04/2016.
 */
public interface Changes {

    @Output("actorChanges")
    MessageChannel actorChanges();

}
