package com.generic.delegate;

import java.io.IOException;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.delegator.service.SearchDelegator;

public class SearchDelegate 
{ 
    private SearchDelegatorLookUp searcDelegatorLookupService = new SearchDelegatorLookUp(); 
    private SearchDelegator serviceDelegator;
    
    private String queryId; 
  
    public void setQueryId(String queryId) 
    { 
        this.queryId = queryId; 
    } 
  
    public GenericGridResponseDTO doTask() throws IOException 
    { 
        serviceDelegator = searcDelegatorLookupService.fetchSearchDelegator(queryId); 
        return serviceDelegator.fetchSearchResults();         
    } 
} 