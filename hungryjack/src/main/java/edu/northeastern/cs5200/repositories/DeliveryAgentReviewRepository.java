package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.DeliveryAgent;
import edu.northeastern.cs5200.models.DeliveryAgentReview;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryAgentReviewRepository extends CrudRepository<DeliveryAgentReview, Integer> {
	
    @Query("SELECT d FROM DeliveryAgentReview d WHERE d.id=:id")
    DeliveryAgentReview findDeliveryAgentReviewById(@Param("id") int id);
}
