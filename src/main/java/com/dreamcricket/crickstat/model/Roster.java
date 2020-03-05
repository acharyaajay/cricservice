package com.dreamcricket.crickstat.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Roster {

    @Id
    @GeneratedValue
    private Integer id;


    private String description;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Player player;


    public Roster() {
    }

    public Roster(String description ,Player player, Team team) {
        this.description = description;
        this.player = player;
        this.team = team;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player team) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", team=" + team+
                ", player=" + player +
                '}';
    }
}
