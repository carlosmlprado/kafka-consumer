package com.study.kafka.entity;

import com.study.kafka.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    private Character status;

    @Column(name = "login_attempt")
    private Integer loginAttempt;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public User toEntity(UserDTO userDTO) {

        return User.builder().name(userDTO.getName()).
                password(userDTO.getPassword()).
                email(userDTO.getEmail()).
                status(userDTO.getStatus()).
                loginAttempt(userDTO.getLoginAttempt()).
                roles(userDTO.getRoles()).build();
    }

}
