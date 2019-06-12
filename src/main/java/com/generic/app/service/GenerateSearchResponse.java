package com.generic.app.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.generic.app.dto.GenericGridResponseDTO;
import com.generic.app.dto.ParentRowDataDTO;

@Component("generateSearchResponse")
public final class GenerateSearchResponse {
	GenericGridResponseDTO genericGridResponseDTO;

	public GenericGridResponseDTO getGenericGridResponse(List<? extends ResultSet> rsData,Map <String,String> columnHeaderMapping) {
		genericGridResponseDTO = new GenericGridResponseDTO();
		
		try {
			List<ParentRowDataDTO> parentRowDataList = new ArrayList<ParentRowDataDTO> ();
		for (ResultSet returnedResult : rsData) {
			ParentRowDataDTO parentRowDTO = new ParentRowDataDTO();
			Map<String, String> rowData = new HashMap();
			ResultSetMetaData rsMetaData = returnedResult.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			
			// The column count starts from 1
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String headerName = columnHeaderMapping.get(columnName);
				rowData.put(headerName, returnedResult.getString(i));
			}
			parentRowDTO.setRowData(rowData);
			parentRowDataList.add(parentRowDTO);
		}
		
		genericGridResponseDTO.setParentRowDataList(parentRowDataList);
		}
		catch(SQLException e) {
			
		}

		return genericGridResponseDTO;

	}
}
