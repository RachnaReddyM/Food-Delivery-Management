package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.OrderStatus;
import edu.northeastern.cs5200.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public void createOrderStatus(String orderedAt, String orderStatus, FoodOrders foodOrders){

        OrderStatus newOrderStatus = new OrderStatus();
        newOrderStatus.setOrderedAt(orderedAt);
        newOrderStatus.setOrderStatus(orderStatus);
        newOrderStatus.setRelatedOrder(foodOrders);
        orderStatusRepository.save(newOrderStatus);
    }

    public void updateOrderStatus(OrderStatus orderStatus, String status){

        Date date = new Date();
        if(status.equals("orderPrepared")){
            orderStatus.setPreparedAt(date.toString());
        }
        else if(status.equals("orderDelivered")){
            orderStatus.setDeliveredAt(date.toString());
        }
        orderStatus.setOrderStatus(status);
        orderStatusRepository.save(orderStatus);
    }
    
    public OrderStatus findOrderStatusById(Integer id){

        return orderStatusRepository.findOrderStatusById(id);
    }

    public OrderStatus findOrderStatusByFoodOrderId(FoodOrders foodOrders){

        return orderStatusRepository.findOrderStatusByFoodOrderId(foodOrders.getId());
    }
}
