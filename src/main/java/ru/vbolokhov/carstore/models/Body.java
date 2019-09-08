package ru.vbolokhov.carstore.models;

import javax.persistence.*;

/**
 * Car body entity.
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "body")
public class Body {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String style;

    public Body() {
    }

    public Body(int id) {
        this.id = id;
    }

    public Body(String style) {
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return id == body.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
