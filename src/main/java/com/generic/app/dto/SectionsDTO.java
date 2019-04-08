package com.generic.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author smohakud
 *
 */

public @Data class SectionsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<SectionDTO> sections = new ArrayList<>();

}