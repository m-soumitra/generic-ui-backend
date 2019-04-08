package com.generic.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.dto.SectionDTO;

/**
 * @author smohakud
 *
 */

@Service("searchService")
public class SearchService {
	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
	public static final Map<String, Integer> QUERY_MAP;
	static {
		Map<String, Integer> tempMap = new HashMap<>();
		tempMap.put("ssn", 1);
		tempMap.put("name", 2);
		QUERY_MAP = Collections.unmodifiableMap(tempMap);
	}

	public SectionDTO createScreenByQueryId(String queryId) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = null;
		switch (QUERY_MAP.get(queryId)) {
		case 1:
			is = SearchService.class.getResourceAsStream("/ssn-screen-respone.json");
			break;
		case 2:
			is = SearchService.class.getResourceAsStream("/name-screen-response.json");
			break;
		default:
			logger.info("QueryId mapping not found");
		}
		return mapper.readValue(is, SectionDTO.class);
	}

	public GenericGridResponseDTO getGridResponse(SearchGridRequestDTO searchGridRequest) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = null;
		switch (QUERY_MAP.get(searchGridRequest.getQueryId())) {
		case 1:
			is = SearchService.class.getResourceAsStream("/grid-response.json");
			break;
		case 2:
			is = SearchService.class.getResourceAsStream("/grid-response.json");
			break;
		default:
			logger.info("QueryId mapping not found");
		}
		return mapper.readValue(is, GenericGridResponseDTO.class);
	}
}
