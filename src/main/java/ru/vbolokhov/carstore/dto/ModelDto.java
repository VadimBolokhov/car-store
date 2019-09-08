package ru.vbolokhov.carstore.dto;

/**
 * Car model DTO.
 * @author Vadim Bolokhov
 */
public class ModelDto {

    private int id;

    private String name;

    public ModelDto() {
    }

    public ModelDto(int id, String name) {
        this.id = id;
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
}
