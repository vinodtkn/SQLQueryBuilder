package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define subquery's json components - parent json object is reused here
 */
@Component
public class SubQueryDetails {
	
	private QueryParameters queryComponents;

	public SubQueryDetails() {
		super();
	}

	public SubQueryDetails(QueryParameters queryComponents) {
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
