package com.generic.app.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;

@Service("searchClient")
public class SearchClient {
	
	@Autowired
	@Qualifier("searchDelegate")
	private SearchDelegate searchDelegate;

	public GenericGridResponseDTO doTask(SearchGridRequestDTO searchGridRequest) throws Exception {
		return searchDelegate.doTask(searchGridRequest);

	}
}
