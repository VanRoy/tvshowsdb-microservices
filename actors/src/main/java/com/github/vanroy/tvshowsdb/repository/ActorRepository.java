package com.github.vanroy.tvshowsdb.repository;

import com.github.vanroy.tvshowsdb.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Actor repository.
 * @author Julien Roy
 */
@RepositoryRestResource
public interface ActorRepository extends CrudRepository<Actor, String> {
}
