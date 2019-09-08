package ru.vbolokhov.carstore.models;

import javax.persistence.*;

/**
 * Car model.
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "model")
public class CarModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    /** Car make */
    @ManyToOne
    @JoinColumn(name = "make_id", nullable = false, updatable = false)
    private Make make;
    /** Car body type */
    @ManyToOne
    @JoinColumn(name = "body_id", nullable = false, updatable = false)
    private Body body;
    /** Car engine type */
    @ManyToOne
    @JoinColumn(name = "engine_id", nullable = false, updatable = false)
    private Engine engine;
    /** Car transmission type */
    @ManyToOne
    @JoinColumn(name = "trans_id", nullable = false, updatable = false)
    private Transmission transmission;

    public CarModel() {
    }

    public CarModel(String name) {
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

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarModel model = (CarModel) o;
        return id == model.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
