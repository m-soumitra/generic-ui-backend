package com.generic.app.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author smohakud
 *
 */

public @Data class SearchGridMetaDataDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer pageNumber;
	private Integer pageSize;
	private Integer totalPages;
	
}
