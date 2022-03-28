package com.sqlquerybuilder.SQLQueryBuilder.parser;

import java.util.List;

import com.sqlquerybuilder.SQLQueryBuilder.dto.OrderByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;

public class QryWithWhrOrdrBy {

	private List<SelectionColumn> selectionColumns;
	private List<WhereConditionParam> whereConditions;
	private List<OrderByConditionParameters> orderByConditions;

	/**
	 * 
	 */
	public QryWithWhrOrdrBy() {
		super();
	}

	/**
	 * @param selectionColumns
	 * @param whereConditions
	 * @param orderByConditions
	 */
	public QryWithWhrOrdrBy(List<SelectionColumn> selectionColumns, List<WhereConditionParam> whereConditions,
			List<OrderByConditionParameters> orderByConditions) {
		super();
		this.selectionColumns = selectionColumns;
		this.whereConditions = whereConditions;
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
