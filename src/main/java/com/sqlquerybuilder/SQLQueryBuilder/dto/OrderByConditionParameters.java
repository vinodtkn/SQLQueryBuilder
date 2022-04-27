package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define order by Condition Parameters
 */
@Component
public class OrderByConditionParameters {
	private String alias;
	private String column;
	private String order;

	/**
	 * 
	 */
	public OrderByConditionParameters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderByConditionParameters(String alias, String column, String order) {
		super();
		this.alias = alias;
		this.column = column;
		this.order = order;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	
}
