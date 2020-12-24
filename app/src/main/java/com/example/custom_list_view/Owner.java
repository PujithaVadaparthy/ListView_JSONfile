package com.example.custom_list_view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    @Expose
    private String login;
    private String repo;

    public String getLogin() {
        return login;
    }
    public String getRepo() {
        return repo;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setRepo(String repo) {
        this.repo = repo;
    }
}
