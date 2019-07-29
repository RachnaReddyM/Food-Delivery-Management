package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.api.Restaurant;
import edu.northeastern.cs5200.api.RestaurantApi;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.RestaurantAddress;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;
import edu.northeastern.cs5200.repositories.RestaurantAddressRepository;
import edu.northeastern.cs5200.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    public RestaurantRepository restaurantRepository;

    @Autowired
    public FoodOrdersRepository foodOrdersRepository;

    @Autowired
    public RestaurantAddressRepository restaurantAddressRepository;


    public List<edu.northeastern.cs5200.models.Restaurant> findRestaurantsByName(String name){

        return restaurantRepository.findRestaurantsByName(name);
    }
    public String findRestaurantKey(int id){
        return restaurantRepository.findRestaurantKey(id);
    }
    
    public List<FoodOrders> findOrdersByRestaurant(edu.northeastern.cs5200.models.Restaurant restaurant) {
    	
    	if (restaurant == null) {
    		return new ArrayList<>();
    	}
    	
    	return restaurantRepository.findOrdersByRestaurantId(restaurant.getId());
    }


    public void addOrder(int id, FoodOrders foodOrders){

        edu.northeastern.cs5200.models.Restaurant restaurant = restaurantRepository.findById(id);

        if(!restaurant.getOrderList().contains(foodOrders)){
            restaurant.getOrderList().add(foodOrders);
            restaurantRepository.save(restaurant);
        }

        if(foodOrders.getRestaurantOrder() == null ||
                (foodOrders.getRestaurantOrder() != null && !foodOrders.getRestaurantOrder().equals(restaurant))){

            foodOrders.setRestaurantOrder(restaurant);
            foodOrdersRepository.save(foodOrders);
        }
    }


    @Override
    public RestaurantApi getAllRestaurants() {

        String url = "https://api.eatstreet.com/publicapi/v1/restaurant/search?method=delivery&street-address=Massachusetts+Ave&";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Access-Token", "__API_EXPLORER_AUTH_KEY__");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<RestaurantApi> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, RestaurantApi.class);
        RestaurantApi restaurant = respEntity.getBody();
        return restaurant;
    }

    public void createRestaurantTable(){

        RestaurantApi restaurantApi = getAllRestaurants();
        if(restaurantApi != null && restaurantApi.getRestaurants().size() > 0){
            List<Restaurant> restaurantList = restaurantApi.getRestaurants();

            for(int i=0;(i<30 && i<restaurantList.size());i++){
                if(restaurantList.get(i) != null){
                    Restaurant eachRestaurant = restaurantList.get(i);
                    String[] deliveryTimes = {};
                    String restaurantName = eachRestaurant.getName();
                    String restaurantKey = eachRestaurant.getApiKey();
                    edu.northeastern.cs5200.models.Restaurant restaurant = new edu.northeastern.cs5200.models.Restaurant();
                    restaurant.setRestaurantName(restaurantName);
                    restaurant.setRestaurantKey(restaurantKey);
                    if(eachRestaurant.getHours().getWednesday() != null){
                        deliveryTimes = eachRestaurant.getHours().getWednesday().get(0).split("-");
                        restaurant.setDeliveryStartTime(deliveryTimes[0]);
                        restaurant.setDeliveryEndTime(deliveryTimes[1]);
                    }

                    String street = eachRestaurant.getStreetAddress();
                    String city = eachRestaurant.getCity();
                    String state = eachRestaurant.getState();
                    String country = "USA";
                    String zipCode = eachRestaurant.getZip();
                    RestaurantAddress restaurantAddress = new RestaurantAddress(street, city, state, country, zipCode, restaurant);

                    restaurantRepository.save(restaurant);
                    restaurantAddressRepository.save(restaurantAddress);
                }
            }
        }
    }

    public List<edu.northeastern.cs5200.models.Restaurant> findAllRestaurnts()
    {
        return (List<edu.northeastern.cs5200.models.Restaurant>) restaurantRepository.findAll();
    }

    public void deleteResById(int id)
    {
        restaurantRepository.deleteById(id);
    }

    public edu.northeastern.cs5200.models.Restaurant findResById(int id)
    {
        return restaurantRepository.findById(id);
    }

    public void updateRestaurant(int id, edu.northeastern.cs5200.models.Restaurant restaurant)
    {
        restaurantRepository.save(restaurant);
    }

    public edu.northeastern.cs5200.models.Restaurant createRes(edu.northeastern.cs5200.models.Restaurant res)
    {
        return restaurantRepository.save(res);
    }
}

