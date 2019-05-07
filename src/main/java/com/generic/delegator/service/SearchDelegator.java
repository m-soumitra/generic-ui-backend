package com.generic.delegator.service;

import java.io.IOException;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;

public interface SearchDelegator 
{ 
    public GenericGridResponseDTO fetchSearchResults(SearchGridRequestDTO searchGridRequest) throws IOException; 
    
} 