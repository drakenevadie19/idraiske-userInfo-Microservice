package com.codedecode.userInfo.service;

import com.codedecode.userInfo.dto.UserDTO;
import com.codedecode.userInfo.entity.User;
import com.codedecode.userInfo.mapper.UserMapper;
import com.codedecode.userInfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        // Use userRepository to save a user
        User savedUser =  userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        // Since the return value must be DTO, convert it User type back to UserDTO type
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchAUser(Integer userId) {
        Optional<User> foundUser = userRepo.findById(userId);
        if (foundUser.isPresent()) {
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(foundUser.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
