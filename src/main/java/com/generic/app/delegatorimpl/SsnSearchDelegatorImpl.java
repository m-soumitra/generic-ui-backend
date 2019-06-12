package com.generic.app.delegatorimpl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.app.delegator.SearchDelegator;
import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.SearchGridRequestDTO;
import com.generic.app.service.DataValidatorService;
import com.generic.app.service.SearchService;

/**
 * @author smohakud
 *
 */
@Service("ssnSearchDelegatorImpl")
public class SsnSearchDelegatorImpl implements SearchDelegator {
	
	@Autowired
	@Qualifier("dataValidatorService")
	private DataValidatorService dataValidator = new DataValidatorService();

	InputStream is = null;

	public GenericGridResponseDTO fetchSearchResults(SearchGridRequestDTO searchGridRequest) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		is = SearchService.class.getResourceAsStream("/grid-response.json");
		String personName = searchGridRequest.getSingleInputFields().get("First Name");
		if (!dataValidator.validateIsString(personName)) {
			throw new Exception("Person Name cannot contain digits.");
		}
		return mapper.readValue(is, GenericGridResponseDTO.class);
	}
}
