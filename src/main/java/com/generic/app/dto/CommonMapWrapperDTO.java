package com.generic.app.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author smohakud
 * 
 *         Generic version of the CommonMapWrapperDTO. This aims to minimize
 *         custom DTOs required.
 * @param <T1> Type of the value being boxed
 * @param <T2> Type of the value being boxed
 */
public class CommonMapWrapperDTO<T1, T2> extends StatusDTO {

	private static final long serialVersionUID = 1L;

	@JsonProperty("results")
	private transient Map<T1, T2> results;

	public Map<T1, T2> getResults() {
		return this.results;
	}

	public void setResults(Map<T1, T2> results) {
		this.results = results;
	}

}
