package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    List<User> findAllUsers();
    User findUserById(int id);

    void deleteUserById(int id);

    void updateUser(int id, String name,String email, String phone, String username);
}
