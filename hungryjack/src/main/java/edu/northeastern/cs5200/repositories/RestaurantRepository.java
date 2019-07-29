package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    @Query("SELECT r FROM Restaurant r WHERE r.restaurantName LIKE CONCAT('%',:name,'%')")
    List<Restaurant> findRestaurantsByName(@Param("name") String name);

    @Query("SELECT r.restaurantKey FROM Restaurant r WHERE r.id=:id")
    String findRestaurantKey(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r WHERE r.id=:id")
    Restaurant findById(@Param("id") int id);
    
    @Query("SELECT f from FoodOrders f where f.restaurantOrder.id=:id")
    List<FoodOrders> findOrdersByRestaurantId(@Param("id") int id);

}
