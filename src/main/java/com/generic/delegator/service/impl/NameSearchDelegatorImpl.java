package com.generic.delegator.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.service.SearchService;
import com.generic.delegator.dao.NameSearchDao;
import com.generic.delegator.service.SearchDelegator;
import com.generic.util.GenerateSearchResponse;

public class NameSearchDelegatorImpl implements SearchDelegator 
{ 
	NameSearchDao nameSearchDao = new NameSearchDao();
	GenerateSearchResponse generateResponse = new GenerateSearchResponse();
	public final static Map <String,String> columnHeaderMapping;
	public final static List<String> headerList;

	   static
	   {
		   headerList = new ArrayList();
		   columnHeaderMapping = new HashMap<String,String>();
		   
		   headerList.add("Person Number");
		   headerList.add("Date of birth");
		   headerList.add("Enrolled");
		   headerList.add("City");
		   columnHeaderMapping.put("Person Number", "person_number");
		   columnHeaderMapping.put("Date of birth", "date_of_birth");
		   columnHeaderMapping.put("Enrolled", "enrolled");
		   columnHeaderMapping.put("City", "city");
		   
	   }
	
	
    public GenericGridResponseDTO fetchSearchResults(SearchGridRequestDTO searchGridRequest) throws IOException  
    { 
    	
    	List<? extends ResultSet> resultSetList = nameSearchDao.fetchNameSearchResults(searchGridRequest);
    	GenericGridResponseDTO gridResponse = generateResponse.getGenericGridResponse(resultSetList, columnHeaderMapping);
    	gridResponse.setHeaderColumns(headerList);
    	//return gridResponse; 
    	InputStream is = null;
    	ObjectMapper mapper = new ObjectMapper();
    	is = SearchService.class.getResourceAsStream("/grid-response.json");
    	return mapper.readValue(is, GenericGridResponseDTO.class);
    } 
} 
