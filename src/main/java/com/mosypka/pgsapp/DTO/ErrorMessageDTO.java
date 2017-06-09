package com.mosypka.pgsapp.DTO;

/**
 * Created by marcin on 09.06.2017.
 */
public class ErrorMessageDTO {

    private String description;

    public ErrorMessageDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
