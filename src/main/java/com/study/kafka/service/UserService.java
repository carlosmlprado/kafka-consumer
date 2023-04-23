package com.study.kafka.service;

import com.study.kafka.dto.UserDTO;
import com.study.kafka.entity.User;
import com.study.kafka.exception.UserAlreadyExistsException;
import com.study.kafka.exception.UserNotFoundException;
import com.study.kafka.exception.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();

        Boolean exists = checkIfUserExistsByEmail(userDTO.getEmail());

        if (!exists)
            userRepository.save(user.toEntity(userDTO));

        userDTO.setId(user.getId());
        return userDTO;
    }


    private Boolean checkIfUserExistsByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if (user.isPresent())
            throw new UserAlreadyExistsException("User already Exists!");

        return false;
    }

    private User checkIfUserExistsById(UUID userId) {
        return userRepository.findById(userId).stream().findFirst().orElseThrow(() -> new UserNotFoundException("User not found!"));
    }
}
