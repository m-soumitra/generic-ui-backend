package com.generic.app.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generic.app.dto.CommonMapWrapperDTO;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.GridResponseWrapper;
import com.generic.app.dto.ScreenCreationResponseWrapper;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.dto.SectionDTO;
import com.generic.app.dto.SectionsDTO;
import com.generic.app.service.SearchService;
import com.generic.constants.Types.HttpStatus;

/**
 * @author smohakud
 *
 */
@RestController
@RequestMapping(value = "app")
public class SearchController {

	@Autowired
	@Qualifier("searchService")
	private SearchService searchService;

	@Value("#{${screenmap:{'ssn':'SSN Screen', 'caseNumber': 'Case Number', 'name': 'Personal Information'}}}")
	private Optional<Map<String, String>> valuesMap;
	
	@Value("#{${delegatormap}}")
	private Map<String, String> delegatormap;

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@GetMapping("generateScreen")
	public ScreenCreationResponseWrapper generateScreen(@RequestParam("queryId") String queryId) {
		logger.info("In Screen creation response");
		ScreenCreationResponseWrapper response = new ScreenCreationResponseWrapper();
		response.setQueryId(queryId);
		try {
			SectionDTO section = searchService.createScreenByQueryId(queryId);
			SectionsDTO sections = new SectionsDTO();
			sections.getSections().add(section);
			response.setResults(sections);
			response.setStatusCd(HttpStatus.OK.getCode());
			response.setMessage(HttpStatus.OK.getMessage());
		} catch (IOException e) {
			logger.error("Exception occurred while Generating screen for queryId {}, Exception is {}", queryId, e);
			response.setStatusCd(HttpStatus.INTERNAL_SERVER_ERROR.getCode());
			response.setMessage("Exception occurred " + e.getMessage());
		}
		return response;
	}

	@PostMapping("fetchGridResponse")
	public GridResponseWrapper fetchGridResponse(@RequestBody SearchGridRequestDTO searchGridRequest) {
		logger.info("Grid response");
		GridResponseWrapper response = new GridResponseWrapper();
		try {
			GenericGridResponseDTO genericGridResponse = searchService.getGridResponse(searchGridRequest);
			response.setResults(genericGridResponse);
			response.setStatusCd(HttpStatus.OK.getCode());
			response.setMessage(HttpStatus.OK.getMessage());
		} catch (Exception e) {
			logger.error("Exception occurred while Grid response for queryId {}, Exception is {}",
					searchGridRequest.getQueryId(), e);
			response.setStatusCd(HttpStatus.INTERNAL_SERVER_ERROR.getCode());
			response.setMessage("Exception occurred " + e.getMessage());
		}
		return response;
	}

	@GetMapping("fetchScreens")
	public CommonMapWrapperDTO<String, String> fetchScreens() {
		System.out.println("In Fetch Screens");
		CommonMapWrapperDTO<String, String> response = new CommonMapWrapperDTO<>();
		try {
			if (valuesMap.isPresent()) {
				response.setResults(valuesMap.get());
			}
			response.setStatusCd(HttpStatus.OK.getCode());
			response.setMessage(HttpStatus.OK.getMessage());
		} catch (Exception e) {
			logger.error("Exception occured while fetching Screen List {}", e);
			response.setStatusCd(HttpStatus.INTERNAL_SERVER_ERROR.getCode());
			response.setMessage("Exception occurred " + e.getMessage());
		}
		return response;
	}
}
