/**
 * 
 */
package com.generic.app.dto;

import java.io.Serializable;

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
public @Data class ValidationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("code")
	private String code;
	@JsonProperty("message")
	private String message;
	@JsonProperty("type")
	private String type;
	@JsonProperty("actionMod")
	private String actionMod;

}
