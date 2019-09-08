package ru.vbolokhov.carstore.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vbolokhov.carstore.models.Gearbox;

import java.util.List;

/**
 * An implementation of CrudRepository for Gearbox entities.
 * @author Vadim Bolokhov
 */
public interface GearboxRepository extends CrudRepository<Gearbox, Integer> {

    List<Gearbox> findAll();
}
