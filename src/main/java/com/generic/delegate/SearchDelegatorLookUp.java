package com.generic.delegate;

import static com.generic.constants.QueryConstants.CASE_NUMBER;
import static com.generic.constants.QueryConstants.SSN;

import com.generic.delegator.service.SearchDelegator;
import com.generic.delegator.service.impl.CaseNumberSearchDelegatorImpl;
import com.generic.delegator.service.impl.NameSearchDelegatorImpl;
import com.generic.delegator.service.impl.SsnSearchDelegatorImpl;

import static com.generic.constants.QueryConstants.NAME;

class SearchDelegatorLookUp  
{ 
    public SearchDelegator fetchSearchDelegator(String queryType) 
    { 
        if(queryType.equalsIgnoreCase(NAME)) 
        { 
            return new NameSearchDelegatorImpl(); 
        } 
        else if(queryType.equalsIgnoreCase(SSN))
        { 
            return new SsnSearchDelegatorImpl(); 
        } 
        else if(queryType.equalsIgnoreCase(CASE_NUMBER))
        { 
            return new CaseNumberSearchDelegatorImpl(); 
        } 
        else 
        	return new CaseNumberSearchDelegatorImpl();

        
   } 
} 
