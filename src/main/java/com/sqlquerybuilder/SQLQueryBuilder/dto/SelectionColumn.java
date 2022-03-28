package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * class to define columns to be selected in the query along with the table name
 */
@Component
public class SelectionColumn {

	private String tableName;
	private ArrayList<String> columnNames;

	public SelectionColumn() {
		super();
	}

	/**
	 * @param tableName
	 * @param columnName
	 */
	public SelectionColumn(String tableName, ArrayList<String> columnNames) {
		super();
		this.tableName = tableName;
		this.columnNames = columnNames;
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
	 * @return the columnNames
	 */
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	/**
	 * @param columnNames the columnNames to set
	 */
	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}

}
