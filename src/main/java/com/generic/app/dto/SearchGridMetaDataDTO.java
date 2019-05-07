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
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
}
