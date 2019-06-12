package com.generic.app.delegate;

import java.lang.reflect.Constructor;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.generic.app.delegator.SearchDelegator;

/**
 * @author smohakud
 *
 */
@Component("searchDelegatorLookUp")
public class SearchDelegatorLookUp {
	private static final Logger logger = LoggerFactory.getLogger(SearchDelegatorLookUp.class);

	@Value("#{${delegatormap}}")
	private Map<String, String> delegatormap;

	public SearchDelegator fetchSearchDelegator(String queryType) {
		Class<?> clazz;
		Object instance = null;
		try {
			clazz = Class.forName(delegatormap.get(queryType));
			Constructor<?> constructor = clazz.getConstructor();
			instance = constructor.newInstance();
		} catch (ClassNotFoundException e) {
			logger.error("Class Not Found", e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return (SearchDelegator) instance;
	}

}
