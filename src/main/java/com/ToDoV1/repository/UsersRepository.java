package com.ToDoV1.repository;

import com.ToDoV1.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByLogin(String login);

}
