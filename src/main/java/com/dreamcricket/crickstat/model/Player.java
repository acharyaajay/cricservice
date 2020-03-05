package com.dreamcricket.crickstat.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.sql.RowSet;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "This is the information about player")
@Entity(name="player")
public class Player {
@Id
@GeneratedValue
private Integer id;
    static final String  sizeMsg = "Name should have at least two characters";
    @Size(min=2, message =sizeMsg)
    @ApiModelProperty(notes=sizeMsg)
    private String name;

    @Size(min=2, message =sizeMsg)
    @ApiModelProperty(notes=sizeMsg)
    private String email;

    private String gender;
    private String phoneNumber;
    private String contactPreference;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(String contactPreference) {
        this.contactPreference = contactPreference;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    private Date dateOfBirth;
    private  boolean isActive;
    private String photoPath;


    public Player(){

    }

    public Player(@Size(min = 2, message = sizeMsg) String name, @Size(min = 2, message = sizeMsg) String email, String gender, String phoneNumber, String contactPreference, Date dateOfBirth, boolean isActive, String photoPath) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.contactPreference = contactPreference;
        this.dateOfBirth = dateOfBirth;
        this.isActive = isActive;
        this.photoPath = photoPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactPreference='" + contactPreference + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isActive=" + isActive +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
