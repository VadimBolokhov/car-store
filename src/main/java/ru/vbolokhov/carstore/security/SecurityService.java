package ru.vbolokhov.carstore.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vbolokhov.carstore.models.User;
import ru.vbolokhov.carstore.models.UserRole;
import ru.vbolokhov.carstore.repository.UserRepository;
import ru.vbolokhov.carstore.repository.UserRolesRepository;

import java.util.List;

/**
 * User Details service.
 * @author Vadim Bolokhov
 */
@Service
public class SecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserRolesRepository userRolesRepository;

    public SecurityService(UserRepository userRepository, UserRolesRepository rolesRepository) {
        super();
        this.userRepository = userRepository;
        this.userRolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Incorrect username: " + username);
        }
        List<UserRole> roles = this.userRolesRepository.findByLogin(username);
        return new AuthenticationDetails(user, roles);
    }
}
