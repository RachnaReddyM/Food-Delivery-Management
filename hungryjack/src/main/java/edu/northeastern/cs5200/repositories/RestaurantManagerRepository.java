package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;
import edu.northeastern.cs5200.models.RestaurantManager;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantManagerRepository extends CrudRepository<RestaurantManager, Integer> {

    @Query("SELECT r FROM RestaurantManager r WHERE r.email=:email")
    RestaurantManager findRestaurantManagerByEmail(@Param("email") String email);
	
}