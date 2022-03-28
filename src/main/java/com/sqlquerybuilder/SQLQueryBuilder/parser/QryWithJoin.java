package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import com.sqlquerybuilder.SQLQueryBuilder.dto.JoinConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;

public class QryWithJoin {

	private List<SelectionColumn> selectionColumns;
	private List<JoinConditionParameters> joinConditions;

	/**
	 * 
	 */
	public QryWithJoin() {
		super();
	}

	/**
	 * @param selectionColumns
	 * @param joinConditions
	 */
	public QryWithJoin(List<SelectionColumn> selectionColumns, List<JoinConditionParameters> joinConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.joinConditions = joinConditions;
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

}
