package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * Class to define Where Condition Parameters
 */
@Component
public class WhereConditionParam {

	private String lefttableName;
	private String leftcolumnName;
	private ArrayList<String> columnValues;
	private String operator;
	private String righttableName;
	private String rightcolumnName;
	private String conditionAppender;

	/**
	 * 
	 */
	public WhereConditionParam() {
		super();
	}

	/**
	 * @param lefttableName
	 * @param leftcolumnName
	 * @param columnValues
	 * @param operator
	 * @param righttableName
	 * @param rightcolumnName
	 * @param conditionAppender
	 */
	public WhereConditionParam(String lefttableName, String leftcolumnName, ArrayList<String> columnValues,
			String operator, String righttableName, String rightcolumnName, String conditionAppender) {
		super();
		this.lefttableName = lefttableName;
		this.leftcolumnName = leftcolumnName;
		this.columnValues = columnValues;
		this.operator = operator;
		this.righttableName = righttableName;
		this.rightcolumnName = rightcolumnName;
		this.conditionAppender = conditionAppender;
	}

	/**
	 * @return the lefttableName
	 */
	public String getLefttableName() {
		return lefttableName;
	}

	/**
	 * @param lefttableName the lefttableName to set
	 */
	public void setLefttableName(String lefttableName) {
		this.lefttableName = lefttableName;
	}

	/**
	 * @return the leftcolumnName
	 */
	public String getLeftcolumnName() {
		return leftcolumnName;
	}

	/**
	 * @param leftcolumnName the leftcolumnName to set
	 */
	public void setLeftcolumnName(String leftcolumnName) {
		this.leftcolumnName = leftcolumnName;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the righttableName
	 */
	public String getRighttableName() {
		return righttableName;
	}

	/**
	 * @param righttableName the righttableName to set
	 */
	public void setRighttableName(String righttableName) {
		this.righttableName = righttableName;
	}

	/**
	 * @return the rightcolumnName
	 */
	public String getRightcolumnName() {
		return rightcolumnName;
	}

	/**
	 * @param rightcolumnName the rightcolumnName to set
	 */
	public void setRightcolumnName(String rightcolumnName) {
		this.rightcolumnName = rightcolumnName;
	}

	/**
	 * @return the columnValues
	 */
	public ArrayList<String> getColumnValues() {
		return columnValues;
	}

	/**
	 * @param columnValues the columnValues to set
	 */
	public void setColumnValues(ArrayList<String> columnValues) {
		this.columnValues = columnValues;
	}

	/**
	 * @return the conditionAppender
	 */
	public String getConditionAppender() {
		return conditionAppender;
	}

	/**
	 * @param conditionAppender the conditionAppender to set
	 */
	public void setConditionAppender(String conditionAppender) {
		this.conditionAppender = conditionAppender;
	}

}
