package com.generic.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.app.delegate.SearchClient;
import com.generic.app.delegate.SearchDelegate;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.dto.SectionDTO;

/**
 * @author smohakud
 *
 */

@Service("searchService")
public class SearchService {

	@Autowired
	@Qualifier("dropDownService")
	private DropDownService dropDownService;

	@Autowired
	@Qualifier("searchClient")
	private SearchClient searchClient;
	
	@Autowired
	@Qualifier("searchDelegate")
	private SearchDelegate searchDelegate;

	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

	public SectionDTO createScreenByQueryId(String queryId) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = null;
		String jsonName = "/" + queryId + "-screen-response.json";
		is = SearchService.class.getResourceAsStream(jsonName);
		SectionDTO section = mapper.readValue(is, SectionDTO.class);
		return dropDownService.populateDropDowns(section);
	}

	public GenericGridResponseDTO getGridResponse(SearchGridRequestDTO searchGridRequest) throws Exception {
		logger.info("In getGridResponse");
		return searchClient.doTask(searchGridRequest);

	}
}
