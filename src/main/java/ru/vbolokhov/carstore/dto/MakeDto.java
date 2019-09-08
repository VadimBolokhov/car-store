package ru.vbolokhov.carstore.dto;

/**
 * Car make DTO.
 * @author Vadim Bolokhov
 */
public class MakeDto {

    private int id;

    private String name;

    public MakeDto() {
    }

    public MakeDto(int id, String name) {
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
