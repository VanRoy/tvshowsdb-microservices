package com.github.vanroy.tvshowsdb.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * TV Show model entity.
 * @author Julien Roy
 */
@Entity
public class Show {

    @Id
    private String id;
    private String name;
    @Column(length = 4096)
    private String description;
    private Integer seasons;
    @ElementCollection
    private Set<String> actorsId;

    public Show() {
    }

    public Show(Show show) {
        this.id = show.id;
        this.name = show.name;
        this.description = show.description;
        this.seasons = show.seasons;
        this.actorsId = show.actorsId;
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

    public Set<String> getActorsId() {
        return actorsId;
    }

    public void setActorsId(Set<String> actorsId) {
        this.actorsId = actorsId;
    }
}
