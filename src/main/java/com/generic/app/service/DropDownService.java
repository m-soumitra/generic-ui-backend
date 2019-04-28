/**
 * 
 */
package com.generic.app.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.generic.app.dto.SectionDTO;
import com.generic.constants.Types.HTMLElements;
import com.generic.constants.Types.Source;

/**
 * @author smohakud
 *
 */
@Service("dropDownService")
public class DropDownService {
	private static final Logger logger = LoggerFactory.getLogger(DropDownService.class);

	public SectionDTO populateDropDowns(SectionDTO sectionDTO) {

		if (ObjectUtils.isEmpty(sectionDTO)) {
			logger.error("Section object should not be null");
		} else {
			sectionDTO.getFields().forEach(field -> {
				String type = field.getType();
				Map<String, String> valueMap = null;
				if (type.equals(HTMLElements.SELECT.getElement())) {
					if (Source.TABLE.getSource().equals(type)) {
						String tableName = field.getData();
						valueMap = null; // Perform DAO Call (type, tableName)
					} else if (Source.QUERY.getSource().equals(type)) {
						String query = field.getData();
						valueMap = new HashMap<>(); // Perform DAO Call (type, query)
					} else if (Source.URL.getSource().equals(type)) {
						String url = field.getData();
						valueMap = new HashMap<>(); // Perform External Service Call (type, url)
					}
				}
				// field.setValues(valueMap);
			});
		}
		return sectionDTO;
	}

}
