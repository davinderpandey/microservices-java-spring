package com.javamigos.userservice.service;

import com.javamigos.userservice.dto.UserDto;
import com.javamigos.userservice.entity.User;
import com.javamigos.userservice.mapper.UserMapper;
import com.javamigos.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;




    public UserDto saveUserInDB(UserDto userDto) {
        User userToBeSaved = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        User savedUser = userRepository.save(userToBeSaved);
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    public UserDto fetchUserById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return UserMapper.INSTANCE.mapUserToUserDto(user.orElse(null));
    }
}
