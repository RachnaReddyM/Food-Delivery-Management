package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.DeliveryDetails;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryDetailesRepository extends CrudRepository<DeliveryDetails, Integer> {
}
