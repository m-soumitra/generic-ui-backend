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
@JsonPropertyOrder({ "rowData","childRowDataList" })
public @Data class ParentRowDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("rowData")
	private Map<String, String> rowData;
	@JsonProperty("childRowGridValues")
	private List<Map<String, String>> childRowGridValues;
	public Map<String, String> getRowData() {
		return rowData;
	}
	public void setRowData(Map<String, String> rowData) {
		this.rowData = rowData;
	}
	public List<Map<String, String>> getChildRowGridValues() {
		return childRowGridValues;
	}
	public void setChildRowGridValues(List<Map<String, String>> childRowGridValues) {
		this.childRowGridValues = childRowGridValues;
	}
	
	
}
