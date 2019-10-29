package ru.vbolokhov.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vbolokhov.carstore.models.UserRole;

import java.util.List;

/**
 * An implementation of JpaRepository for UserRole entities.
 * @author Vadim Bolokhov
 */
public interface UserRolesRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByLogin(String login);
}
