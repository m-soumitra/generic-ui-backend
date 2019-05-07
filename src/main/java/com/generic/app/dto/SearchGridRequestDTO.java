package com.generic.app.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author smohakud
 *
 */

public @Data class SearchGridRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String token;
    private String queryId;
    private Map<String, String> singleInputFields;
    private Map<String, List<String>> multiInputFields;
    private SearchGridMetaDataDTO gridMetadata;
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public Map<String, String> getSingleInputFields() {
		return singleInputFields;
	}
	public void setSingleInputFields(Map<String, String> singleInputFields) {
		this.singleInputFields = singleInputFields;
	}
	public Map<String, List<String>> getMultiInputFields() {
		return multiInputFields;
	}
	public void setMultiInputFields(Map<String, List<String>> multiInputFields) {
		this.multiInputFields = multiInputFields;
	}
	public SearchGridMetaDataDTO getGridMetadata() {
		return gridMetadata;
	}
	public void setGridMetadata(SearchGridMetaDataDTO gridMetadata) {
		this.gridMetadata = gridMetadata;
	}
	
    
    
    
}
