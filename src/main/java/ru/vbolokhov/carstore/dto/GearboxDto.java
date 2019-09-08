package ru.vbolokhov.carstore.dto;

/**
 * Gearbox DTO.
 * @author Vadim Bolokhov
 */
public class GearboxDto {

    private int id;

    private String type;

    public GearboxDto() {
    }

    public GearboxDto(int id, String type) {
        this.id = id;
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
}
