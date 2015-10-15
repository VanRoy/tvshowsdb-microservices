package com.github.vanroy.tvshowsdb.model;

import java.util.Date;

/**
 * Actor model.
 * @author Julien Roy
 */
public class Actor {

    private String name;
    private String bio;
    private Date birthdate;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
