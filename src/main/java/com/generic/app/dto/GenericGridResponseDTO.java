package com.generic.app.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * @author smohakud
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "queryId", "headerColumns", "childColumns", "dataKeyColumn", "parentRowDataList" })
public @Data class GenericGridResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("queryId")
	private String queryId;

	@JsonProperty("headerColumns")
	private List<String> headerColumns;

	@JsonProperty("childColumns")
	private List<String> childColumns;

	@JsonProperty("dataKeyColumn")
	private String dataKeyColumn;

	@JsonProperty("parentRowDataList")
	private List<ParentRowDataDTO> parentRowDataList;
	
	@Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
