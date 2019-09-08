package ru.vbolokhov.carstore.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vbolokhov.carstore.models.Make;

import java.util.List;

/**
 * An implementation of CrudRepository for Make entities.
 * @author Vadim Bolokhov
 */
public interface MakesRepository extends CrudRepository<Make, Integer> {

    List<Make> findAll();
}
