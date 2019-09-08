package ru.vbolokhov.carstore.dto;

/**
 * Car engine DTO.
 * @author Vadim Bolokhov
 */
public class EngineDto {

    private int id;

    private String type;

    public EngineDto() {
    }

    public EngineDto(int id, String type) {
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
