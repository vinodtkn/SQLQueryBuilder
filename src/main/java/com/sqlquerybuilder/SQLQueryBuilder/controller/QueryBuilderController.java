package com.sqlquerybuilder.SQLQueryBuilder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlquerybuilder.SQLQueryBuilder.dto.QueryComponents;
import com.sqlquerybuilder.SQLQueryBuilder.utils.QryBldrUtils;

/**
 * class to define all the api endpoints for query builder
 */
@RestController
public class QueryBuilderController {

	private String query;

	/**
	 * generates query for the provided input json
	 */
	@PostMapping(path = "/selectQuery", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQuery(@RequestBody QueryComponents queryComponents) {
		query = QryBldrUtils.getSlctQry(queryComponents);
		return query;
	}

	
}
