package com.dreamcricket.crickstat.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "This is the information about team")
@Entity(name="team")
public class Team {
@Id
@GeneratedValue
private Integer id;
    static final String  sizeMsg = "Name should have at least two characters";

    @Size(min=2, message =sizeMsg)
    @ApiModelProperty(notes=sizeMsg)
    private String teamName;


    @Size(min=2, message =sizeMsg)
    @ApiModelProperty(notes=sizeMsg)
    private Date cutOffDate;


    public Team(){

    }
    public Team(@Size(min = 2, message = sizeMsg) String name,  Date cutOffDate) {
        this.teamName= name;
        this.cutOffDate = cutOffDate;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }

    public Date getCutOffDate() {
        return cutOffDate;
    }

    public void setCutOffDate(Date date) {
        this.cutOffDate= date;
    }


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", cutOffDate='" + cutOffDate + '\''+
                '}';
    }
}
