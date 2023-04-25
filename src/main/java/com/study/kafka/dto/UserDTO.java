package com.study.kafka.dto;

import com.study.kafka.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UUID id;
    private String name;
    private String password;
    private String email;
    private Character status;
    private Integer loginAttempt;

    public UserDTO toDto(User user) {

        return UserDTO.builder().name(user.getName()).
                password(user.getPassword()).
                email(user.getEmail()).
                status(user.getStatus()).
                loginAttempt(user.getLoginAttempt())
                .build();
    }

}
