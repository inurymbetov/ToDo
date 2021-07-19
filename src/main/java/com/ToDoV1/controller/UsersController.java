package com.ToDoV1.controller;

import com.ToDoV1.model.Users;
import com.ToDoV1.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UsersController {

    private UsersService usersService;

    @GetMapping("/api1/users/{login}")
    private Users getUser(@PathVariable String login) throws Exception {
        return usersService.getUsers(login);
    }

    @PostMapping("/api1/users/add")
    private ResponseEntity<Users> addUsers(@RequestBody Users users) throws Exception {
        return new ResponseEntity<>(usersService.addUsers(users), HttpStatus.CREATED);
    }

    @DeleteMapping("/api1/users/del/{id}")
    private HttpStatus deleteUsers(@PathVariable int id){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        if (!usersService.deleteUsers(id)){
            return status = HttpStatus.OK;
        }
        return status;
    }

}
