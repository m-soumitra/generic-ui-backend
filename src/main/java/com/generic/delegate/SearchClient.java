package com.generic.delegate;

import java.io.IOException;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;

public class SearchClient  
{ 
    SearchDelegate searchDelegate; 
  
    public SearchClient(SearchDelegate searchDelegate) 
    { 
        this.searchDelegate  = searchDelegate; 
    } 
  
    public GenericGridResponseDTO doTask(SearchGridRequestDTO searchGridRequest) throws IOException 
    {         
    	return searchDelegate.doTask(searchGridRequest);
		
    } 
} 
