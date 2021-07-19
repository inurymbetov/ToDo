package com.ToDoV1.service;

import com.ToDoV1.model.Users;
import com.ToDoV1.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Users getUsers(String login) throws Exception {
        return usersRepository.findByLogin(login).orElseThrow(() -> new Exception("Users not found"));
    }

    @Transactional
    public Users addUsers(Users users) throws Exception {
        return usersRepository.save(Optional.ofNullable(users).orElseThrow(() -> new Exception("Null entity users")));
    }

    public boolean deleteUsers(int id){
        boolean result = false;
        usersRepository.deleteById(id);
        if (usersRepository.findById(id).isPresent()){
            result = true;
        }
        return result;
    }

}
