package com.github.vanroy.tvshowsdb.service;

import java.util.List;

import com.github.vanroy.tvshowsdb.model.Actor;
import com.github.vanroy.tvshowsdb.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Actor Rest Service.
 * @author Julien Roy
 */
//@RestController
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/actors")
    Iterable<Actor> getActors() {
        return actorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/actors/{name}")
    Actor get(@PathVariable("name") String name) {
        return actorRepository.findOne(name);
    }

}
