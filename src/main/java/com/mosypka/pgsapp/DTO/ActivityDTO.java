package com.mosypka.pgsapp.DTO;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by marcin on 09.06.2017.
 */
public class ActivityDTO {

    private Long id;
    @NotNull
    @Size(min=4, max=50)
    private String name;

    @NotNull
    @Future
    private Date startDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
