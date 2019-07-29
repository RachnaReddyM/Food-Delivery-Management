package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.DeliveryAgent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryAgentRepository extends CrudRepository<DeliveryAgent, Integer> {

    @Query("SELECT d FROM DeliveryAgent d WHERE d.email=:email")
    DeliveryAgent findDeliveryAgentByEmail(@Param("email") String email);
    
    Page<DeliveryAgent> findAll(Pageable pageable);

    @Query("SELECT d FROM DeliveryAgent d WHERE d.id=:id")
    DeliveryAgent findDeliveryAgentById(@Param("id") int id);

}
