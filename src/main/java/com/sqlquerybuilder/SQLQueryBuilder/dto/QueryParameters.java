package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Class to define individual json components
 */
@Component
public class QueryParameters {

	private List<String> tableNames;
	private List<String> tableAliases;
	private List<SelectionColumnParameters> selectionColumns;
	private WhereConditionDetails whereConditions;
	private List<JoinConditionParameters> joinConditions;
	private List<GroupByConditionParameters> groupByColumns;
	private List<OrderByConditionParameters> orderByConditions;
	
	public QueryParameters() {
		super();
	}

	public QueryParameters(List<String> tableNames, List<String> tableAliases,
			List<SelectionColumnParameters> selectionColumns, WhereConditionDetails whereConditions,
			List<JoinConditionParameters> joinConditions, List<GroupByConditionParameters> groupByColumns,
			List<OrderByConditionParameters> orderByConditions) {
		super();
		this.tableNames = tableNames;
		this.tableAliases = tableAliases;
		this.selectionColumns = selectionColumns;
		this.whereConditions = whereConditions;
		this.joinConditions = joinConditions;
		this.groupByColumns = groupByColumns;
		this.orderByConditions = orderByConditions;
	}

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

	public List<String> getTableAliases() {
		return tableAliases;
	}

	public void setTableAliases(List<String> tableAliases) {
		this.tableAliases = tableAliases;
	}

	public List<SelectionColumnParameters> getSelectionColumns() {
		return selectionColumns;
	}

	public void setSelectionColumns(List<SelectionColumnParameters> selectionColumns) {
		this.selectionColumns = selectionColumns;
	}

	public WhereConditionDetails getWhereConditions() {
		return whereConditions;
	}

	public void setWhereConditions(WhereConditionDetails whereConditions) {
		this.whereConditions = whereConditions;
	}

	public List<JoinConditionParameters> getJoinConditions() {
		return joinConditions;
	}

	public void setJoinConditions(List<JoinConditionParameters> joinConditions) {
		this.joinConditions = joinConditions;
	}

	public List<GroupByConditionParameters> getGroupByColumns() {
		return groupByColumns;
	}

	public void setGroupByColumns(List<GroupByConditionParameters> groupByColumns) {
		this.groupByColumns = groupByColumns;
	}

	public List<OrderByConditionParameters> getOrderByConditions() {
		return orderByConditions;
	}

	public void setOrderByConditions(List<OrderByConditionParameters> orderByConditions) {
		this.orderByConditions = orderByConditions;
	}

	
	

	/*
	 * public QueryParameters(TableNames tableNames, TableAliases tableAliases,
	 * SelectionColumnDetails selectionColumns, WhereConditionDetails
	 * whereConditions, JoinConditionDetails joinConditions, GroupByConditionDetails
	 * groupByColumns, OrderByConditionDetails orderByConditions) { super();
	 * this.tableNames = tableNames; this.tableAliases = tableAliases;
	 * this.selectionColumns = selectionColumns; this.whereConditions =
	 * whereConditions; this.joinConditions = joinConditions; this.groupByColumns =
	 * groupByColumns; this.orderByConditions = orderByConditions; }
	 * 
	 * public QueryParameters(TableNames tableNames, TableAliases tableAliases) {
	 * super(); this.tableNames = tableNames; this.tableAliases = tableAliases;
	 * this.selectionColumns = null; this.whereConditions = null;
	 * this.joinConditions = null; this.groupByColumns = null;
	 * this.orderByConditions = null; }
	 * 
	 * public TableNames getTableNames() { return tableNames; }
	 * 
	 * public void setTableNames(TableNames tableNames) { this.tableNames =
	 * tableNames; }
	 * 
	 * public TableAliases getTableAliases() { return tableAliases; }
	 * 
	 * public void setTableAliases(TableAliases tableAliases) { this.tableAliases =
	 * tableAliases; }
	 * 
	 * public SelectionColumnDetails getSelectionColumns() { return
	 * selectionColumns; }
	 * 
	 * public void setSelectionColumns(SelectionColumnDetails selectionColumns) {
	 * this.selectionColumns = selectionColumns; }
	 * 
	 * public WhereConditionDetails getWhereConditions() { return whereConditions; }
	 * 
	 * public void setWhereConditions(WhereConditionDetails whereConditions) {
	 * this.whereConditions = whereConditions; }
	 * 
	 * public JoinConditionDetails getJoinConditions() { return joinConditions; }
	 * 
	 * public void setJoinConditions(JoinConditionDetails joinConditions) {
	 * this.joinConditions = joinConditions; }
	 * 
	 * public GroupByConditionDetails getGroupByColumns() { return groupByColumns; }
	 * 
	 * public void setGroupByColumns(GroupByConditionDetails groupByColumns) {
	 * this.groupByColumns = groupByColumns; }
	 * 
	 * public OrderByConditionDetails getOrderByConditions() { return
	 * orderByConditions; }
	 * 
	 * public void setOrderByConditions(OrderByConditionDetails orderByConditions) {
	 * this.orderByConditions = orderByConditions; }
	 */
	
	
}
