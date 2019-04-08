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
    
}
