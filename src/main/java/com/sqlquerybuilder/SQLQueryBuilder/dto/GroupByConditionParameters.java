package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define group by condition parameters
 */
@Component
public class GroupByConditionParameters {

	/**
	 * 
	 */
	public GroupByConditionParameters() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String tableName;
	private String columnName;

	/**
	 * @param tableName
	 * @param columnName
	 */
	public GroupByConditionParameters(String tableName, String columnName) {
		super();
		this.tableName = tableName;
		this.columnName = columnName;
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

}
