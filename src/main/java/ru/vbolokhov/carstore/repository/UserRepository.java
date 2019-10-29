package ru.vbolokhov.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vbolokhov.carstore.models.User;

/**
 * An implementation of JpaRepository for User entities.
 * @author Vadim Bolokhov
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}
