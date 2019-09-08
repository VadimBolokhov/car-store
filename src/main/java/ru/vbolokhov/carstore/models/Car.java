package ru.vbolokhov.carstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Car entity.
 * @author Vadim Bolokhov
 */
@Entity
@Table(name = "car")
public class Car {
    /** Car id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "mod_id", updatable = false, nullable = false)
    private CarModel model;
    @ManyToOne
    @JoinColumn(name = "gear_id")
    private Gearbox gearbox;
    @Column(name = "odometer")
    private double odometer;
    @Column(name = "price")
    private double price;
    @Column(name = "sold")
    private boolean sold;
    @Column(name = "description")
    private String desc;
    @Column(name = "post_date", updatable = false, nullable = false)
    private LocalDateTime postDate;
    /** Color */
    @Enumerated(EnumType.ORDINAL)
    private Color color;
    @ManyToOne
    @JsonIgnoreProperties({"cars", "registration", "role"})
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return 17;
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", model=" + (model == null ? "null" : model.getId())
                + ", gearbox=" + (gearbox == null ? "null" : gearbox.getId())
                + ", odometer=" + odometer
                + ", price=" + price
                + ", sold=" + sold
                + ", desc='" + desc + '\''
                + ", postDate=" + postDate
                + ", color=" + color
                + ", owner=" + (owner == null ? "null" : owner.getId())  + '}';
    }
}
