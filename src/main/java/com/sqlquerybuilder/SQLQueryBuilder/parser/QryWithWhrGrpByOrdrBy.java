package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import com.sqlquerybuilder.SQLQueryBuilder.dto.GroupByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.OrderByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;

public class QryWithWhrGrpByOrdrBy {

	private List<SelectionColumn> selectionColumns;
	private List<WhereConditionParam> whereConditions;
	private List<GroupByConditionParameters> groupByConditions;
	private List<OrderByConditionParameters> orderByConditions;

	/**
	 * 
	 */
	public QryWithWhrGrpByOrdrBy() {
		super();
	}

	/**
	 * @param selectionColumns
	 * @param whereConditions
	 * @param groupByConditions
	 * @param orderByConditions
	 */
	public QryWithWhrGrpByOrdrBy(List<SelectionColumn> selectionColumns, List<WhereConditionParam> whereConditions,
			List<GroupByConditionParameters> groupByConditions, List<OrderByConditionParameters> orderByConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.whereConditions = whereConditions;
		this.groupByConditions = groupByConditions;
		this.orderByConditions = orderByConditions;
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

	/**
	 * @return the orderByConditions
	 */
	public List<OrderByConditionParameters> getOrderByConditions() {
		return orderByConditions;
	}

	/**
	 * @param orderByConditions the orderByConditions to set
	 */
	public void setOrderByConditions(List<OrderByConditionParameters> orderByConditions) {
		this.orderByConditions = orderByConditions;
	}

}
