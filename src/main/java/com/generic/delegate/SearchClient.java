package com.generic.delegate;

import java.io.IOException;

import com.generic.app.dto.GenericGridResponseDTO;

public class SearchClient  
{ 
    SearchDelegate searchDelegate; 
  
    public SearchClient(SearchDelegate searchDelegate) 
    { 
        this.searchDelegate  = searchDelegate; 
    } 
  
    public GenericGridResponseDTO doTask() throws IOException 
    {         
    	return searchDelegate.doTask();
		
    } 
} 
