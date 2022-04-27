package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * Class to define where condition parameters
 */
@Component
public class WhereConditionDetails {
	
	private String conditionAppender;
	private ArrayList<WhereConditionParameters> conditions;
	
	
	public WhereConditionDetails() {
		super();
	}


	public WhereConditionDetails(String conditionAppender,
			ArrayList<WhereConditionParameters> conditions) {
		super();
		this.conditionAppender = conditionAppender;
		this.conditions = conditions;
	}


	public String getConditionAppender() {
		return conditionAppender;
	}


	public void setConditionAppender(String conditionAppender) {
		this.conditionAppender = conditionAppender;
	}


	public ArrayList<WhereConditionParameters> getConditions() {
		return conditions;
	}


	public void setWhereConditionParam(ArrayList<WhereConditionParameters> conditions) {
		this.conditions = conditions;
	}
	
	

}
