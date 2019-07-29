package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email){

        return userRepository.findUserByEmail(email);
    }

    public List<User> findAllUsers ()
    {
        return (List<User>)userRepository.findAll();

    }

    public User findUserById(int id){

        return userRepository.findUserById(id);

    }

    public void deleteUserById(int id)
    {
        userRepository.deleteById(id);
    }

    public void updateUser(int id, String name,String email, String phone, String username)
    {
        userRepository.updateUser(id, name, email,phone,username);
    }
}
