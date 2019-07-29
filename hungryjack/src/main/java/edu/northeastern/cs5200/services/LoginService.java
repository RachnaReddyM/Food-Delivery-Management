package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.forms.LoginForm;
import edu.northeastern.cs5200.models.User;

public interface LoginService {

    boolean authenticateLogin(LoginForm loginForm, User user);
}
