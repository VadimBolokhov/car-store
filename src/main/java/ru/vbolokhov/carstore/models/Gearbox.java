package ru.vbolokhov.carstore.models;

import javax.persistence.*;

/**
 * A gearbox.
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "gearbox")
public class Gearbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String type;

    public Gearbox() {
    }

    public Gearbox(int id) {
        this.id = id;
    }

    public Gearbox(String type) {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gearbox gearbox = (Gearbox) o;
        return id == gearbox.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
