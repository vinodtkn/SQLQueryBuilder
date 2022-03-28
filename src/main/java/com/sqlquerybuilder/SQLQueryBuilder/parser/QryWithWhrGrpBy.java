package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import com.sqlquerybuilder.SQLQueryBuilder.dto.GroupByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;

public class QryWithWhrGrpBy {
	private List<SelectionColumn> selectionColumns;
	private List<WhereConditionParam> whereConditions;
	private List<GroupByConditionParameters> groupByConditions;

	/**
	 * 
	 */
	public QryWithWhrGrpBy() {
		super();
	}

	/**
	 * @param selectionColumns
	 * @param whereConditions
	 * @param groupByConditions
	 */
	public QryWithWhrGrpBy(List<SelectionColumn> selectionColumns, List<WhereConditionParam> whereConditions,
			List<GroupByConditionParameters> groupByConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.whereConditions = whereConditions;
		this.groupByConditions = groupByConditions;
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

	/**
	 * @return the groupByConditions
	 */
	public List<GroupByConditionParameters> getGroupByConditions() {
		return groupByConditions;
	}

	/**
	 * @param groupByConditions the groupByConditions to set
	 */
	public void setGroupByConditions(List<GroupByConditionParameters> groupByConditions) {
		this.groupByConditions = groupByConditions;
	}

}
