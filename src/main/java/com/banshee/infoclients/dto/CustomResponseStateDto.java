package com.banshee.infoclients.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseStateDto implements Serializable {
    private static final long serialVersionUID = -6711586660014186688L;
    protected String message;
    protected String error;
    protected Integer status;
    protected String path;
}
