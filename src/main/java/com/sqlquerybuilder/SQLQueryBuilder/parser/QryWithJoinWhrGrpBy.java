package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import com.sqlquerybuilder.SQLQueryBuilder.dto.GroupByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.JoinConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;

public class QryWithJoinWhrGrpBy {
	private List<SelectionColumn> selectionColumns;
	private List<JoinConditionParameters> joinConditions;
	private List<WhereConditionParam> whereConditions;
	private List<GroupByConditionParameters> groupByConditions;
	
	/**
	 * 
	 */
	public QryWithJoinWhrGrpBy() {
		super();
	}
	/**
	 * @param selectionColumns
	 * @param joinConditions
	 * @param whereConditions
	 * @param groupByConditions
	 */
	public QryWithJoinWhrGrpBy(List<SelectionColumn> selectionColumns, List<JoinConditionParameters> joinConditions,
			List<WhereConditionParam> whereConditions, List<GroupByConditionParameters> groupByConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.joinConditions = joinConditions;
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
