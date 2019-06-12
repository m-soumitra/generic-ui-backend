package com.generic.app.delegator;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;

public interface SearchDelegator 
{ 
    public GenericGridResponseDTO fetchSearchResults(SearchGridRequestDTO searchGridRequest) throws Exception; 
    
} 