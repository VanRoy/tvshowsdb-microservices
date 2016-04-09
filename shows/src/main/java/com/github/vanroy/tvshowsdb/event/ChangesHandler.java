package com.github.vanroy.tvshowsdb.event;

import com.github.vanroy.tvshowsdb.model.Actor;
import com.github.vanroy.tvshowsdb.repository.ShowRepository;
import com.github.vanroy.tvshowsdb.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by julien on 08/04/2016.
 */
@Component
@EnableBinding(Changes.class)
public class ChangesHandler {

    @Autowired
    private ShowService showService;

    @StreamListener(Changes.ACTOR_CHANGES)
    public void handleActorChanges(Actor actor) {

        showService.updateActor(actor);
    }
}
