package com.sqlquerybuilder.SQLQueryBuilder.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class for custom exception to throw errors for malformed queries
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QueryMalformedException extends RuntimeException{

	/**
	 * @param message
	 */
	public QueryMalformedException(String message) {
		super(message);
	}

	
}
