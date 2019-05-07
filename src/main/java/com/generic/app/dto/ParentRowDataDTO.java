package com.generic.app.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author smohakud
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "rowData", "childRowDataHeader", "childRowDataList" })
public @Data class ParentRowDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("rowData")
	private Map<String, String> rowData;
	@JsonProperty("childRowDataHeader")
	private List<String> childRowDataHeader;
	@JsonProperty("childRowDataList")
	private List<Map<String, String>> childRowDataList;
	public Map<String, String> getRowData() {
		return rowData;
	}
	public void setRowData(Map<String, String> rowData) {
		this.rowData = rowData;
	}
	public List<String> getChildRowDataHeader() {
		return childRowDataHeader;
	}
	public void setChildRowDataHeader(List<String> childRowDataHeader) {
		this.childRowDataHeader = childRowDataHeader;
	}
	public List<Map<String, String>> getChildRowDataList() {
		return childRowDataList;
	}
	public void setChildRowDataList(List<Map<String, String>> childRowDataList) {
		this.childRowDataList = childRowDataList;
	}
	
	
}
