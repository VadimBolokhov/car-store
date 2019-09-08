package ru.vbolokhov.carstore.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vbolokhov.carstore.models.Car;

import java.util.List;

/**
 * An implementation of CrudRepository for Car entities.
 * @author Vadim Bolokhov
 */
public interface CarsRepository extends CrudRepository<Car, Integer> {

    List<Car> findAll();

    List<Car> findAllBySold(boolean isSold);
}
