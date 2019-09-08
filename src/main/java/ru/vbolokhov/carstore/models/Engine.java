package ru.vbolokhov.carstore.models;

import javax.persistence.*;

/**
 * Car engine type.
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "engine")
public class Engine {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String type;

    public Engine() {
    }

    public Engine(int id) {
        this.id = id;
    }

    public Engine(String type) {
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
        Engine engine = (Engine) o;
        return id == engine.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
