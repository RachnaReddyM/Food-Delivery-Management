package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Restaurant;
import edu.northeastern.cs5200.models.RestaurantAddress;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantAddressRepository extends CrudRepository<RestaurantAddress, Integer> {

    @Modifying
    @Query("UPDATE RestaurantAddress set street= :street, city= :city, state= :state, country=:country, zipcode=:zipcode WHERE  id =:addId")
    void updateRestaurantAddress(@Param("addId") int addId, @Param("street") String street, @Param("city") String city,
                                 @Param("state") String state, @Param("country") String country, @Param("zipcode") String zipcode);

    @Query("Select r.id from RestaurantAddress r where r.restaurant=:res")
    RestaurantAddress findByRestaurantId(@Param("res")Restaurant res);
}
