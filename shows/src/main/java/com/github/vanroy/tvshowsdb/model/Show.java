package com.github.vanroy.tvshowsdb.model;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * TV Show model entity.
 * @author Julien Roy
 */
public class Show {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer seasons;
    private List<Actor> actors;

    public Show() {
    }

    public Show(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Show(String id, String name, String description, Integer seasons, List<Actor> actors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.seasons = seasons;
        this.actors = actors;
    }

    public Show(Show show) {
        this.id = show.id;
        this.name = show.name;
        this.description = show.description;
        this.seasons = show.seasons;
        this.actors = show.actors;
    }

    public Show(Show show, List<Actor> actors) {
        this(show);
        this.actors = actors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
