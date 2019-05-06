package com.generic.delegator.service;

import java.io.IOException;

import com.generic.app.dto.GenericGridResponseDTO;

public interface SearchDelegator 
{ 
    public GenericGridResponseDTO fetchSearchResults() throws IOException; 
    
} 