package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;

@Component
public class QryWithWhr {

	private List<SelectionColumn> selectionColumns;
	private List<WhereConditionParam> whereConditions;

	/**
	 * 
	 */
	public QryWithWhr() {
		super();
	}

	/**
	 * @param selectionColumns
	 * @param whereConditions
	 */
	public QryWithWhr(List<SelectionColumn> selectionColumns, List<WhereConditionParam> whereConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.whereConditions = whereConditions;
	}

	/**
	 * @return the selectionColumns
	 */
	public List<SelectionColumn> getSelectionColumns() {
		return selectionColumns;
	}

	/**
	 * @param selectionColumns the selectionColumns to set
	 */
	public void setSelectionColumns(List<SelectionColumn> selectionColumns) {
		this.selectionColumns = selectionColumns;
	}

	/**
	 * @return the whereConditions
	 */
	public List<WhereConditionParam> getWhereConditions() {
		return whereConditions;
	}

	/**
	 * @param whereConditions the whereConditions to set
	 */
	public void setWhereConditions(List<WhereConditionParam> whereConditions) {
		this.whereConditions = whereConditions;
	}

}
