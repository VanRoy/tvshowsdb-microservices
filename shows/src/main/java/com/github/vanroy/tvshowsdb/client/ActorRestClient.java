package com.github.vanroy.tvshowsdb.client;

import java.util.List;

import com.github.vanroy.tvshowsdb.model.Actor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Actors REST Client.
 * @author Julien Roy
 */
@FeignClient("actors")
public interface ActorRestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/actors")
    List<Actor> getActors();

    @RequestMapping(method = RequestMethod.GET, value = "/actors/{id}")
    Actor get(@PathVariable("id") String id);
}
