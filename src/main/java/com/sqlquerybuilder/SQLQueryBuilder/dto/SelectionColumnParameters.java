package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * class to define columns to be selected in the query
 */
@Component
public class SelectionColumnParameters {

	private String alias;
	private ArrayList<String> columns;

	public SelectionColumnParameters() {
		super();
	}

	public SelectionColumnParameters(String alias, ArrayList<String> columns) {
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
