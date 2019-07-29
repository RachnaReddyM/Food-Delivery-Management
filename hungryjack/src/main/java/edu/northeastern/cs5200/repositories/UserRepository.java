package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    User findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id=:id")
    User findUserById(@Param("id") int id);

    @Modifying
    @Query("UPDATE User set username= :username, firstName= :name, email= :email,lastName=:name, phone=:phone WHERE id=:id")
    void updateUser(@Param("id") int id, @Param("name") String name, @Param("email") String email,@Param("phone") String phone,@Param("username") String username);
}
