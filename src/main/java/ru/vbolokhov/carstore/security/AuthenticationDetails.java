package ru.vbolokhov.carstore.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.vbolokhov.carstore.models.User;
import ru.vbolokhov.carstore.models.UserRole;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vadim Bolokhov
 */
public class AuthenticationDetails implements UserDetails {

    private User user;

    private List<UserRole> userRoles;

    public AuthenticationDetails(User user, List<UserRole> roles) {
        super();
        this.user = user;
        this.userRoles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userRoles == null ? Collections.emptySet()
                : this.userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
