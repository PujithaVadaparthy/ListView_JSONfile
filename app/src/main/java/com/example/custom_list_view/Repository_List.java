package com.example.custom_list_view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository_List {
    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("full_name")
    @Expose
    private String full_name;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
