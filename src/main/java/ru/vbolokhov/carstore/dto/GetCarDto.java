package ru.vbolokhov.carstore.dto;

import ru.vbolokhov.carstore.models.Color;

import java.time.LocalDateTime;

/**
 * Car DTO.
 * @author Vadim Bolokhov
 */
public class GetCarDto {

    private int id;

    private double odometer;

    private double price;

    private boolean sold;

    private String desc;

    private LocalDateTime postDate;

    private Color color;

    private UserDto owner;

    private MakeDto make;

    private ModelDto model;

    private BodyDto body;

    private EngineDto engine;

    private TransDto transmission;

    private GearboxDto gearbox;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public MakeDto getMake() {
        return make;
    }

    public void setMake(MakeDto make) {
        this.make = make;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public BodyDto getBody() {
        return body;
    }

    public void setBody(BodyDto body) {
        this.body = body;
    }

    public EngineDto getEngine() {
        return engine;
    }

    public void setEngine(EngineDto engine) {
        this.engine = engine;
    }

    public TransDto getTransmission() {
        return transmission;
    }

    public void setTransmission(TransDto transmission) {
        this.transmission = transmission;
    }

    public GearboxDto getGearbox() {
        return gearbox;
    }

    public void setGearbox(GearboxDto gearbox) {
        this.gearbox = gearbox;
    }
}
