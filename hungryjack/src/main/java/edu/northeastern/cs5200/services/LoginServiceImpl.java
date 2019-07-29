package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.forms.LoginForm;
import edu.northeastern.cs5200.models.User;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    public boolean authenticateLogin(LoginForm loginForm, User user){

        if(loginForm.getEmail().equals(user.getEmail()) && loginForm.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
