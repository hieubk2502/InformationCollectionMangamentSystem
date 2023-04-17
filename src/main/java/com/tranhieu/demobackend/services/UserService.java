package com.tranhieu.demobackend.services;

import com.tranhieu.demobackend.entities.User;
import com.tranhieu.demobackend.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto creatUser(UserDto user);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);


}
