package ru.vbolokhov.carstore.converter;

import ru.vbolokhov.carstore.models.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * An implementation of AttributeConverter interface for Role enum.
 * @author Vadim Bolokhov
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role == null ? null : role.name();
    }

    @Override
    public Role convertToEntityAttribute(String s) {
        return s == null ? null
                : Stream.of(Role.values())
                .filter(role -> role.name().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
