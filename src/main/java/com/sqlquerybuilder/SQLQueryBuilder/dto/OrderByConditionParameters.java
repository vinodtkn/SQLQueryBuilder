package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define order by Condition Parameters
 */
@Component
public class OrderByConditionParameters {
	private String tableName;
	private String columnName;
	private String order;

	/**
	 * 
	 */
	public OrderByConditionParameters() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tableName
	 * @param columnName
	 * @param order
	 */
	public OrderByConditionParameters(String tableName, String columnName, String order) {
		super();
		this.tableName = tableName;
		this.columnName = columnName;
		this.order = order;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
}
