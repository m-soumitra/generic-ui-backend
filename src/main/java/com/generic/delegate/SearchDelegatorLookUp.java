package com.generic.delegate;

import  com.generic.constants.QueryIdConstants;

import com.generic.delegator.service.SearchDelegator;
import com.generic.delegator.service.impl.CaseNumberSearchDelegatorImpl;
import com.generic.delegator.service.impl.NameSearchDelegatorImpl;
import com.generic.delegator.service.impl.SsnSearchDelegatorImpl;


class SearchDelegatorLookUp  
{ 
    public SearchDelegator fetchSearchDelegator(String queryType) 
    { 
        if(queryType.equalsIgnoreCase(QueryIdConstants.NAME)) 
        { 
            return new NameSearchDelegatorImpl(); 
        } 
        else if(queryType.equalsIgnoreCase(QueryIdConstants.SSN))
        { 
            return new SsnSearchDelegatorImpl(); 
        } 
        else if(queryType.equalsIgnoreCase(QueryIdConstants.CASE_NUMBER))
        { 
            return new CaseNumberSearchDelegatorImpl(); 
        } 
        else 
        	return new CaseNumberSearchDelegatorImpl();

        
   } 
} 
