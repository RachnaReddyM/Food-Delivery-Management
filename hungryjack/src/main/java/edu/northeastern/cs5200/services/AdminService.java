package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Customer;

public interface AdminService {

    Admin findByEmail(String email);
    Admin saveUser(Admin admin);
}
