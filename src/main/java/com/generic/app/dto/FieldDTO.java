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
	private List<ValidationDTO> validationList;
	@JsonProperty("source")
	private String source;
	@JsonProperty("data")
	private String data;
	@JsonProperty("values")
	private Map<String, String> values;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String get_default() {
		return _default;
	}

	public void set_default(String _default) {
		this._default = _default;
	}

	public List<ValidationDTO> getValidationList() {
		return validationList;
	}

	public void setValidationList(List<ValidationDTO> validationList) {
		this.validationList = validationList;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

}
