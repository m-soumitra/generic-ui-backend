package com.generic.constants;

import java.util.HashMap;
import java.util.Map;

public class NameSearchHeaderMapping {

	public final static Map <String,String> columnHeaderMapping;

	   static
	   {
		   columnHeaderMapping = new HashMap<String,String>();
		   columnHeaderMapping.put("Person Number", "person_number");
		   columnHeaderMapping.put("Date of birth", "date_birth");
		   columnHeaderMapping.put("Enrolled", "enrolled");
		   columnHeaderMapping.put("City", "city");

	   }
	
}
