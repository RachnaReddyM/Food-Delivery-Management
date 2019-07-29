package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    @Query("SELECT c FROM Admin c WHERE c.email=:email")
    Admin findAdminByEmail(@Param("email") String email);
}
