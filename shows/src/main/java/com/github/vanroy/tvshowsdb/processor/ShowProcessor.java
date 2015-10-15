package com.github.vanroy.tvshowsdb.processor;

import java.util.List;
import java.util.stream.Collectors;

import com.github.vanroy.tvshowsdb.model.Actor;
import com.github.vanroy.tvshowsdb.client.ActorClient;
import com.github.vanroy.tvshowsdb.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * Processor that add actors to TV Show resources.
 * @author Julien Roy
 */
@Component
public class ShowProcessor implements ResourceProcessor<Resource<? extends Show>> {

    @Autowired
    ActorClient actorClient;

    @Override
    public Resource<Show> process(Resource<? extends Show> resource) {

        Show show = resource.getContent();

        List<Actor> actors = show.getActors().stream().map(actorClient::loadActorInfo).collect(Collectors.toList());

        return new Resource<>(new Show(show, actors), resource.getLinks());
    }
}
