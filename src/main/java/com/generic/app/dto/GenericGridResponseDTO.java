package com.generic.app.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author smohakud
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "queryId", "headerColumns", "parentRowDataList" })
public @Data class GenericGridResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("queryId")
	private String queryId;

	@JsonProperty("headerColumns")
	private List<String> headerColumns;

	@JsonProperty("parentRowDataList")
	private List<ParentRowDataDTO> parentRowDataList;
}
