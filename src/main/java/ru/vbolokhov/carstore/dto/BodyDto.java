package ru.vbolokhov.carstore.dto;

/**
 * Car body DTO.
 * @author Vadim Bolokhov
 */
public class BodyDto {

    private int id;

    private String style;

    public BodyDto() {
    }

    public BodyDto(int id, String style) {
        this.id = id;
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
}
