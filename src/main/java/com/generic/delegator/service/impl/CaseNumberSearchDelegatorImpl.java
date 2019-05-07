package com.generic.delegator.service.impl;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.service.SearchService;
import com.generic.delegator.service.SearchDelegator;

public class CaseNumberSearchDelegatorImpl implements SearchDelegator 
{ 
	InputStream is = null;
	
    public GenericGridResponseDTO fetchSearchResults(SearchGridRequestDTO searchGridRequest) throws IOException  
    { 
    	ObjectMapper mapper = new ObjectMapper();
    	is = SearchService.class.getResourceAsStream("/grid-response.json");
    	return mapper.readValue(is, GenericGridResponseDTO.class);
    } 
} 