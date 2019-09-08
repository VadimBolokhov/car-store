package ru.vbolokhov.carstore.dto;

/**
 * User DTO.
 * @author Vadim Bolokhov
 */
public class UserDto {

    private int id;

    private String firstname;

    private String lastname;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.firstname + " " + this.lastname;
    }
}
