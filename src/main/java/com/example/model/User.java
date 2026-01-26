package com.example.model;

import io.quarkus.security.IdentityAttribute;

@IdentityAttribute("UserEntity")
public class User {
    public String name;
    public String email;
}