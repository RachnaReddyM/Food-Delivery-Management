package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.FoodOrders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FoodOrdersRepository extends CrudRepository<FoodOrders, Integer> {

    @Query("SELECT f FROM FoodOrders f WHERE f.id=:id")
    FoodOrders findFoodOrderById(@Param("id") int id);
}
