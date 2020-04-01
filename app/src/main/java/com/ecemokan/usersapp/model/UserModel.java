package com.ecemokan.usersapp.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("login")
    String login;

    @SerializedName("id")
    Integer id;

    @SerializedName("html_url")
    String htmlUrl;

    @SerializedName("avatar_url")
    String avatarUrl;

    public UserModel(String login, Integer id, String htmlUrl, String avatarUrl) {
        this.login = login;
        this.id = id;
        this.htmlUrl = htmlUrl;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
