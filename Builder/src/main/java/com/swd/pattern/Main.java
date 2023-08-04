package com.swd.pattern;

import com.swd.pattern.model.User;

public class Main {
    public static void main(String[] args) {

        // Using the builder to create a user instance
        User user = new User.UserBuilder("Mike","Oscar")
                .phone("4356-0989")
                .build();

        System.out.println("User instance created: " + user.toString());

    }
}