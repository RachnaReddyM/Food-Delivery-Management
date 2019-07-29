package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.repositories.AdminRepository;
import edu.northeastern.cs5200.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin findByEmail(String email){

        return adminRepository.findAdminByEmail(email);
    }

    public Admin saveUser(Admin ad)
    {
        return adminRepository.save(ad);
    }

}
