package com.generic.app.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author smohakud
 *
 */

public @Data class StatusDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String message;
    private Integer statusCd;

}
