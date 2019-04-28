/**
 * 
 */
package com.generic.constants;

/**
 * @author smohakud
 *
 */
public class Types {

	public enum HttpStatus {
		OK("Successful", 200), CREATED("Record Created", 201), NO_CONTENT("Record Updated Successfully", 204),
		NOT_FOUND("No Results Found", 404), BAD_REQUEST("Bad Request", 400),
		INTERNAL_SERVER_ERROR("Internal Server Error", 500);

		private final String message;
		private final Integer code;

		HttpStatus(String message, Integer code) {
			this.message = message;
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public Integer getCode() {
			return code;
		}
	}

	public enum HTMLElements {
		SELECT("select"), INPUT_TEXT("text"), NUMBER("number"), CHECKBOX("checkbox");

		private final String element;

		HTMLElements(String element) {
			this.element = element;
		}

		public String getElement() {
			return this.element;
		}
	}

	public enum Source {
		TABLE("table"), QUERY("query"), URL("url");

		private final String source;

		Source(String source) {
			this.source = source;
		}

		public String getSource() {
			return this.source;
		}
	}
	
	public enum MetaDataEnum {
		
	}

}
