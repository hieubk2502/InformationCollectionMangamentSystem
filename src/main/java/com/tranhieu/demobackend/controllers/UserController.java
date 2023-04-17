package com.tranhieu.demobackend.controllers;

import com.tranhieu.demobackend.payloads.ApiResponse;
import com.tranhieu.demobackend.payloads.UserDto;
import com.tranhieu.demobackend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users/")
public class UserController {
    @Autowired
    private UserService userService;
    // Post-Create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto=this.userService.creatUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // Put - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
        UserDto updateUserDto = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updateUserDto);
    }

    // delete- delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
//        return new ResponseEntity(Map.of("message","User Deleted Successfully!"), HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
    }

    // get-user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getSingleUser(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){

        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
