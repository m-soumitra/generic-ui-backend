package com.generic.app.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.generic.app.delegator.SearchDelegator;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;

@Component("searchDelegate")
public class SearchDelegate {
	
	@Autowired
	@Qualifier("searchDelegatorLookUp")
	private SearchDelegatorLookUp searcDelegatorLookupService;

	private SearchDelegator serviceDelegator;

	public GenericGridResponseDTO doTask(SearchGridRequestDTO searchGridRequest) throws Exception {
		serviceDelegator = searcDelegatorLookupService.fetchSearchDelegator(searchGridRequest.getQueryId());
		return serviceDelegator.fetchSearchResults(searchGridRequest);
	}
}