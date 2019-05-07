package com.generic.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author smohakud
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "fields" })
public @Data class SectionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
	@JsonProperty("fields")
	@Valid
	private List<FieldDTO> fields = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FieldDTO> getFields() {
		return fields;
	}
	public void setFields(List<FieldDTO> fields) {
		this.fields = fields;
	}
	
	

}
