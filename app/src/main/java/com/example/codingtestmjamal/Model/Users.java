package com.example.codingtestmjamal.Model;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("id")
    private int id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("emailId")
    private String emailId;
    @SerializedName("password")
    private String password;
    @SerializedName("roleid")
    private int roleid;
    @SerializedName("isActive")
    private Boolean isActive;

    public Users(String firstName, String lastName, String emailId, String password, int roleid, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.roleid = roleid;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public int getRoleid() {
        return roleid;
    }

    public Boolean getActive() {
        return isActive;
    }
}
