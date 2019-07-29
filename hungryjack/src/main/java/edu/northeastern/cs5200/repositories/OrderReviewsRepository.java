package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.OrderReviews;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderReviewsRepository extends CrudRepository<OrderReviews, Integer> {
	
    @Query("SELECT d FROM OrderReviews d WHERE d.id=:id")
    OrderReviews findOrderReviewById(@Param("id") int id);


}
