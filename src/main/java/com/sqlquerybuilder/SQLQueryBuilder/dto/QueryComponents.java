package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to hold the whole input json object
 */
@Component
public class QueryComponents {
	
	private QueryParameters queryComponents;

	public QueryComponents() {
		super();
	}

	public QueryComponents(QueryParameters queryComponents) {
		super();
		this.queryComponents = queryComponents;
	}

	public QueryParameters getQueryComponents() {
		return queryComponents;
	}

	public void setQueryComponents(QueryParameters queryComponents) {
		this.queryComponents = queryComponents;
	}

	
}
