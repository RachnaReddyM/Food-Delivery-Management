package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.OrderContents;
import org.springframework.data.repository.CrudRepository;

public interface OrderContentsRepository extends CrudRepository<OrderContents, Integer> {
}
