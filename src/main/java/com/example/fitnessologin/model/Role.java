package com.example.fitnessologin.model;

import org.assertj.core.util.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.fitnessologin.model.PersonPermission.*;

public enum Role {
    PREMIUM(Lists.newArrayList(BLOG_READ, EXERCISE_READ)),
    ADMIN(Lists.newArrayList(BLOG_READ, BLOG_WRITE, EXERCISE_READ, EXERCISE_WRITE)),
    TRAINER(Lists.newArrayList(EXERCISE_READ, EXERCISE_WRITE, BLOG_READ));

    private final List<PersonPermission> permissions;

    Role(List<PersonPermission> permissions) {
        this.permissions = permissions;
    }

    public List<PersonPermission> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority((permission.getPermission())))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
