/**
 * 
 */
package com.generic.app.service;

import org.springframework.stereotype.Service;

/**
 * @author smohakud
 *
 */
@Service("dataValidatorService")
public class DataValidatorService {

	public Boolean validateIsString(String input) {
		if(input.matches(".*\\d.*")) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
