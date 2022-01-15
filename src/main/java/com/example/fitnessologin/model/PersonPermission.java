package com.example.fitnessologin.model;

public enum PersonPermission {
    BLOG_READ("blog:read"),
    BLOG_WRITE("blog:write"),
    EXERCISE_READ("exercise:read"),
    EXERCISE_WRITE("exercise:write");

    private final String permission;

    PersonPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
