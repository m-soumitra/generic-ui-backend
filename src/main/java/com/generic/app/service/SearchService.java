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
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.dto.SectionDTO;
import com.generic.delegate.SearchClient;
import com.generic.delegate.SearchDelegate;

/**
 * @author smohakud
 *
 */

@Service("searchService")
public class SearchService {

	@Autowired
	@Qualifier("dropDownService")
	DropDownService dropDownService;

	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
	public static final Map<String, Integer> QUERY_MAP;
	static {
		Map<String, Integer> tempMap = new HashMap<>();
		tempMap.put("ssn", 1);
		tempMap.put("name", 2);
		tempMap.put("caseNumber", 2);
		QUERY_MAP = Collections.unmodifiableMap(tempMap);
	}

	public SectionDTO createScreenByQueryId(String queryId) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = null;
		String jsonName = "/" + queryId + "-screen-response.json";
		is = SearchService.class.getResourceAsStream(jsonName);
		SectionDTO section = mapper.readValue(is, SectionDTO.class);
		return dropDownService.populateDropDowns(section);
	}

	public GenericGridResponseDTO getGridResponse(SearchGridRequestDTO searchGridRequest) throws IOException {

		SearchDelegate searchDelegate = new SearchDelegate();
		searchDelegate.setQueryId(searchGridRequest.getQueryId());

		SearchClient searchClient = new SearchClient(searchDelegate);
		return searchClient.doTask();

	}

//	public GenericGridResponseDTO getGridResponse(SearchGridRequestDTO searchGridRequest) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		// Abstract Factory Pattern to	 get corresponding DAO class (Delegator)
//		InputStream is = null;
//		switch (QUERY_MAP.get(searchGridRequest.getQueryId())) {
//		case 1:
//			is = SearchService.class.getResourceAsStream("/grid-response.json");
//			break;
//		case 2:
//			is = SearchService.class.getResourceAsStream("/grid-response.json");
//			break;
//		default:
//			logger.info("QueryId mapping not found");
//		}
//		return mapper.readValue(is, GenericGridResponseDTO.class);
//	}
}
