package com.example.dto;

import com.example.model.User;
import java.time.LocalDateTime;

public class UserResponse {
    public Long id;
    public String name;
    public String email;
    public LocalDateTime createdAt;

    public static UserResponse from(User user) {
        UserResponse dto = new UserResponse();
        dto.id = user.id;
        dto.name = user.name;
        dto.email = user.email;
        dto.createdAt = user.createdAt;
        return dto;
    }
}
