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
@JsonPropertyOrder({ "name", "title", "type", "default", "validations", "defaultValues" })
public @Data class FieldDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
	@JsonProperty("title")
	private String title;
	@JsonProperty("type")
	private String type;
	@JsonProperty("default")
	private String _default;
	@JsonProperty("validations")
	private List<Map<String, String>> validations;
	@JsonProperty("source")
	private String source;
	@JsonProperty("data")
	private String data;
	@JsonProperty("values")
	private Map<String, String> values;

}
