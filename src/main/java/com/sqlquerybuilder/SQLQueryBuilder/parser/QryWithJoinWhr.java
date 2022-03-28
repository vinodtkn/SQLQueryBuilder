package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import com.sqlquerybuilder.SQLQueryBuilder.dto.JoinConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;

public class QryWithJoinWhr {
	private List<SelectionColumn> selectionColumns;
	private List<JoinConditionParameters> joinConditions;
	private List<WhereConditionParam> whereConditions;
	/**
	 * 
	 */
	public QryWithJoinWhr() {
		super();
	}
	
	/**
	 * @param selectionColumns
	 * @param joinConditions
	 * @param whereConditions
	 */
	public QryWithJoinWhr(List<SelectionColumn> selectionColumns, List<JoinConditionParameters> joinConditions,
			List<WhereConditionParam> whereConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.joinConditions = joinConditions;
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
	 * @return the joinConditions
	 */
	public List<JoinConditionParameters> getJoinConditions() {
		return joinConditions;
	}
	/**
	 * @param joinConditions the joinConditions to set
	 */
	public void setJoinConditions(List<JoinConditionParameters> joinConditions) {
		this.joinConditions = joinConditions;
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
