package com.example.apifilms.repositories;

import com.example.apifilms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    boolean existsUserByUsernameAndPassword(String username,String password);
}
