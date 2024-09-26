package org.example;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findByAddress(String address); // O cualquier otro método que necesites
}
