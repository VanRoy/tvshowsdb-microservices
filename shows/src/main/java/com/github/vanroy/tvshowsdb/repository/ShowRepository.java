package com.github.vanroy.tvshowsdb.repository;

import com.github.vanroy.tvshowsdb.model.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * TV Show repository.
 * @author Julien Roy
 */
@RepositoryRestResource
public interface ShowRepository extends CrudRepository<Show, String> {
}
