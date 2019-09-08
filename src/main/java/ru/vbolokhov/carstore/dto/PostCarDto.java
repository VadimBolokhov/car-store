package ru.vbolokhov.carstore.dto;

import ru.vbolokhov.carstore.models.Color;

/**
 * Car DTO for 'post' requests.
 * @author Vadim Bolokhov
 */
public class PostCarDto {

    private String desc;
    private double price;
    private double odometer;
    private Color color;
    private int ownerId;
    private int modelId;
    private int gearboxId;

    public PostCarDto() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getGearboxId() {
        return gearboxId;
    }

    public void setGearboxId(int gearboxId) {
        this.gearboxId = gearboxId;
    }
}
