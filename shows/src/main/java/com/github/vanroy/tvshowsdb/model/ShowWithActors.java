package com.github.vanroy.tvshowsdb.model;

import java.util.List;

/**
 * Composition of Show with Actors
 * @author Julien Roy
 */
public class ShowWithActors extends Show {

    private final List<Actor> actors;

    public ShowWithActors(Show show, List<Actor> actors) {
        super(show);
        this.actors = actors;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
