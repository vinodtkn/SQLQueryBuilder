package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * Class to define group by condition parameters
 */
@Component
public class GroupByConditionParameters {
	
	private String alias;
	private ArrayList<String> columns;
	
	/**
	 * 
	 */
	public GroupByConditionParameters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GroupByConditionParameters(String alias, ArrayList<String> columns) {
		super();
		this.alias = alias;
		this.columns = columns;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public ArrayList<String> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}

	

}
