package ru.vbolokhov.carstore.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vbolokhov.carstore.models.CarModel;


import java.util.List;

/**
 * An implementation of CrudRepository for Model entities.
 * @author Vadim Bolokhov
 */
public interface ModelRepository extends CrudRepository<CarModel, Integer> {

    List<CarModel> findAll();

    List<CarModel> findAllByMakeId(int makeId);
}
