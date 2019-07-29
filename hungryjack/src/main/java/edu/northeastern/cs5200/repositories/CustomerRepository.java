package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.email=:email")
    Customer findCustomerByEmail(@Param("email") String email);
}
