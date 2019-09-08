package ru.vbolokhov.carstore.models;

import javax.persistence.*;

/**
 * Car transmission type.
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "transmission")
public class Transmission {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String type;

    public Transmission() {
    }

    public Transmission(int id) {
        this.id = id;
    }

    public Transmission(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmission that = (Transmission) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
