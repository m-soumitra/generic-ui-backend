package com.generic.app.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author smohakud
 *
 */

@EqualsAndHashCode(callSuper=true)
public @Data class GridResponseWrapper extends StatusDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private GenericGridResponseDTO results;

}
