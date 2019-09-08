package ru.vbolokhov.carstore.models;

import javax.persistence.*;

/**
 * Car make
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "make")
public class Make {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    public Make() {
    }

    public Make(int id) {
        this.id = id;
    }

    public Make(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Make make = (Make) o;
        return id == make.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
