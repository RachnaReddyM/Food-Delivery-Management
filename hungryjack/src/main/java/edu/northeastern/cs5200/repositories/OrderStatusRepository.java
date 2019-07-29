package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.OrderStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer> {

    @Query("SELECT o FROM OrderStatus o WHERE o.relatedOrder=:id")
    OrderStatus findOrderStatusByFoodOrderId(@Param("id") int id);
    
    @Query("SELECT o FROM OrderStatus o WHERE o.id=:id")
    OrderStatus findOrderStatusById(@Param("id") int id);
}
