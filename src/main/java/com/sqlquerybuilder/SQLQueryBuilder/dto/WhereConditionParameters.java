package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define individual json components in where clause
 */
@Component
public class WhereConditionParameters {

	private String comparingAlias;
	private String comparingColumn;
	private String comparingOperator;
	private boolean comparingWithColumn;
	private boolean comparingWithValue;
	private String comparingValue;
	private boolean comparingWithSubQuery;
	private String comparableTableAlias;
	private String comparableColumn;
	private SubQueryDetails subQueryDetails;

	/**
	 * 
	 */
	public WhereConditionParameters() {
		super();
	}

	public WhereConditionParameters(String comparingAlias, String comparingColumn, String comparingOperator,
			boolean comparingWithColumn, boolean comparingWithValue, String comparingValue,
			boolean comparingWithSubQuery, String comparableTableAlias, String comparableColumn,
			SubQueryDetails subQueryDetails) {
		super();
		this.comparingAlias = comparingAlias;
		this.comparingColumn = comparingColumn;
		this.comparingOperator = comparingOperator;
		this.comparingWithColumn = comparingWithColumn;
		this.comparingWithValue = comparingWithValue;
		this.comparingValue = comparingValue;
		this.comparingWithSubQuery = comparingWithSubQuery;
		this.comparableTableAlias = comparableTableAlias;
		this.comparableColumn = comparableColumn;
		this.subQueryDetails = subQueryDetails;
	}

	public String getComparingColumn() {
		return comparingColumn;
	}

	public void setComparingColumn(String comparingColumn) {
		this.comparingColumn = comparingColumn;
	}

	public String getComparingOperator() {
		return comparingOperator;
	}

	public void setComparingOperator(String comparingOperator) {
		this.comparingOperator = comparingOperator;
	}

	public boolean isComparingWithColumn() {
		return comparingWithColumn;
	}

	public void setComparingWithColumn(boolean comparingWithColumn) {
		this.comparingWithColumn = comparingWithColumn;
	}

	public boolean isComparingWithValue() {
		return comparingWithValue;
	}

	public void setComparingWithValue(boolean comparingWithValue) {
		this.comparingWithValue = comparingWithValue;
	}

	public String getComparingValue() {
		return comparingValue;
	}

	public void setComparingValue(String comparingValue) {
		this.comparingValue = comparingValue;
	}

	public boolean isComparingWithSubQuery() {
		return comparingWithSubQuery;
	}

	public void setComparingWithSubQuery(boolean comparingWithSubQuery) {
		this.comparingWithSubQuery = comparingWithSubQuery;
	}

	public String getComparableTableAlias() {
		return comparableTableAlias;
	}

	public void setComparableTableAlias(String comparableTableAlias) {
		this.comparableTableAlias = comparableTableAlias;
	}

	public String getComparableColumn() {
		return comparableColumn;
	}

	public void setComparableColumn(String comparableColumn) {
		this.comparableColumn = comparableColumn;
	}

	public SubQueryDetails getSubQueryDetails() {
		return subQueryDetails;
	}

	public void setSubQueryDetails(SubQueryDetails subQueryDetails) {
		this.subQueryDetails = subQueryDetails;
	}

	public String getComparingAlias() {
		return comparingAlias;
	}

	public void setComparingAlias(String comparingAlias) {
		this.comparingAlias = comparingAlias;
	}

}
