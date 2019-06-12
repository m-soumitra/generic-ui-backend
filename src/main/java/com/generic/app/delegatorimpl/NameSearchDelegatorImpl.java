package com.generic.app.delegatorimpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.app.dao.NameSearchDao;
import com.generic.app.delegator.SearchDelegator;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.service.GenerateSearchResponse;
import com.generic.app.service.SearchService;

public class NameSearchDelegatorImpl implements SearchDelegator {
	@Autowired
	private NameSearchDao nameSearchDao;

	@Autowired
	@Qualifier("generateSearchResponse")
	private GenerateSearchResponse generateResponse;
	protected static final Map<String, String> columnHeaderMapping;
	protected static final List<String> headerList;

	static {
		headerList = new ArrayList<>();
		columnHeaderMapping = new HashMap<>();

		headerList.add("Person Number");
		headerList.add("Date of birth");
		headerList.add("Enrolled");
		headerList.add("City");
		columnHeaderMapping.put("Person Number", "person_number");
		columnHeaderMapping.put("Date of birth", "date_of_birth");
		columnHeaderMapping.put("Enrolled", "enrolled");
		columnHeaderMapping.put("City", "city");

	}

	public GenericGridResponseDTO fetchSearchResults(SearchGridRequestDTO searchGridRequest) throws IOException {

//		List<? extends ResultSet> resultSetList = nameSearchDao.fetchNameSearchResults(searchGridRequest);
//		GenericGridResponseDTO gridResponse = generateResponse.getGenericGridResponse(resultSetList,
//				columnHeaderMapping);
//		gridResponse.setHeaderColumns(headerList);
		// return gridResponse;
		InputStream is = null;
		ObjectMapper mapper = new ObjectMapper();
		is = SearchService.class.getResourceAsStream("/grid-response.json");
		return mapper.readValue(is, GenericGridResponseDTO.class);
	}
}
