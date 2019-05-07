package com.generic.delegator.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.generic.app.dto.SearchGridRequestDTO;

public class NameSearchDao {

	public static final String SELECT_PERSON = "SELECT person_number,date_of_birth,enrolled,city "
			+ "from PERSON WHERE 1 = 1";
	
	public static final String BY_FIRST_NAME = "AND FIRST_NAME = :firstName";
	public static final String BY_LAST_NAME = "AND LAST_NAME = :lastName";

	public List<? extends ResultSet> fetchNameSearchResults(SearchGridRequestDTO searchGridRequest) {
		Map<String, String> searchParams = searchGridRequest.getSingleInputFields();
		return null;
	}

}
