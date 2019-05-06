package com.generic.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.constants.NameSearchHeaderMapping;

public class GenerateSearchResponse {
	GenericGridResponseDTO genericGridResponseDTO;
	NameSearchHeaderMapping columnHeaderMapping;

	private GenericGridResponseDTO setGenericGridResponse(List<? extends ResultSet> rsData) throws SQLException {

		for (ResultSet returnedResult : rsData) {
			ResultSetMetaData rsMetaData = returnedResult.getMetaData();
			int columnCount = rsMetaData.getColumnCount();

			// The column count starts from 1
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String headerName = columnHeaderMapping.columnHeaderMapping.get(columnName);

			}

		}

		return genericGridResponseDTO;

	}
}
