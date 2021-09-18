package com.example.realworld.application.users.dto;

import com.example.realworld.application.users.domain.Profile;
import com.example.realworld.application.users.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private final String email;
    private final String userName;
    private final String bio;
    private final String image;
    private final String token;

    private ResponseUser(String email, String userName, Profile profile, String token) {
        this.email = email;
        this.userName = userName;
        this.bio = profile.getBio();
        this.image = profile.getImage();
        this.token = token;
    }

    public static ResponseUser of(User user) {
        return new ResponseUser(user.getEmail(), user.userName(), user.getProfile(), user.getToken());
    }
}
