package com.sqlquerybuilder.SQLQueryBuilder.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.sqlquerybuilder.SQLQueryBuilder.constants.JoinTypes;
import com.sqlquerybuilder.SQLQueryBuilder.constants.OrderByCondition;
import com.sqlquerybuilder.SQLQueryBuilder.constants.QueryConstants;
import com.sqlquerybuilder.SQLQueryBuilder.constants.WhereClauseCombinations;
import com.sqlquerybuilder.SQLQueryBuilder.constants.WhereClauseOperators;
import com.sqlquerybuilder.SQLQueryBuilder.dto.GroupByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.JoinConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.OrderByConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumn;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumns;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParam;
import com.sqlquerybuilder.SQLQueryBuilder.errorhandler.QueryMalformedException;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoin;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoinWhr;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoinWhrGrpBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoinWhrGrpByOrdrBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhr;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhrGrpBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhrGrpByOrdrBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhrOrdrBy;

/**
 * class to contain the utils for building the SQL query
 */

@Component
public class QueryBuilderUtils {

	/**
	 * @return select phrase along with columns & table names
	 */
	public static String getSlctQry(SelectionColumns queryParams) {

		List<SelectionColumn> columns = queryParams.getSelectionColumns();

		StringBuilder sbTables = new StringBuilder();
		StringBuilder sbColumns = new StringBuilder();
		for (SelectionColumn selectColumn : columns) {
			if (sbTables != null && sbTables.length() > 0) {
				sbTables.append(",");
			}
			sbTables.append(selectColumn.getTableName());
			if (selectColumn.getColumnNames() == null || selectColumn.getColumnNames().size() == 0
					|| selectColumn.getColumnNames().isEmpty()) {
				sbColumns.append("*");
			} else {
				for (String column : selectColumn.getColumnNames()) {
					if (sbColumns != null && sbColumns.length() > 0) {
						sbColumns.append(",");
					}
					sbColumns.append(selectColumn.getTableName()).append(QueryConstants.DOT_OPERATOR).append(column);
				}
			}
		}
		StringBuilder tempQuery = new StringBuilder();
		tempQuery.append(QueryConstants.SELECT_PHRASE);
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(sbColumns);
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(QueryConstants.FROM_PHRASE);
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(sbTables);
		return tempQuery.toString();
	}

	/**
	 * @return select phrase with columns, table names & where condition
	 */
	public static String getSlctQryWithWhr(QryWithWhr queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		SelectionColumns columns = new SelectionColumns(queryParams.getSelectionColumns());
		tempQuery.append(getSlctQry(columns));
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(getWhereClause(queryParams.getWhereConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return where phrase - called from parent method; if where condition has
	 *         column values, right table and right column would not be considered
	 *         even if it has values.
	 */
	private static Object getWhereClause(List<WhereConditionParam> whereConditionParam) {
		StringBuilder whereClause = new StringBuilder();
		if (whereConditionParam != null && whereConditionParam.size() > 0) {

			whereClause.append(QueryConstants.WHERE_PHRASE);
			for (WhereConditionParam conditionParams : whereConditionParam) {
				whereClause.append(conditionParams.getLefttableName());
				whereClause.append(QueryConstants.DOT_OPERATOR);
				whereClause.append(conditionParams.getLeftcolumnName());
				whereClause.append(QueryConstants.SINGLE_SPACE);
				whereClause.append(WhereClauseOperators.contains(conditionParams.getOperator()));
				whereClause.append(QueryConstants.SINGLE_SPACE);
				if (conditionParams.getColumnValues() != null && conditionParams.getColumnValues().size() > 0) {
					whereClause.append(getColVals(conditionParams.getOperator(), conditionParams.getColumnValues()));
					whereClause.append(QueryConstants.SINGLE_SPACE);
				} else {
					whereClause.append(conditionParams.getRighttableName());
					whereClause.append(QueryConstants.DOT_OPERATOR);
					whereClause.append(conditionParams.getRightcolumnName());
					whereClause.append(QueryConstants.SINGLE_SPACE);
				}
				whereClause.append(
						getCndtnAppndr(WhereClauseCombinations.contains(conditionParams.getConditionAppender())));
			}
		}
		return whereClause.toString();
	}

	/**
	 * @return column values phrase for where clause; framed based on the operator
	 *         in where clause
	 */
	private static String getColVals(String whereClauseOperator, ArrayList<String> columnValues) {
		String tempColVal = StringUtils.join(columnValues, "\", \"");
		String prefinalColVal = StringUtils.wrap(tempColVal, "\"");
		String finalColVal = prefinalColVal;
		if (whereClauseOperator.equals("IN")) {
			finalColVal = "(" + prefinalColVal + ")";
		}
		if (whereClauseOperator.equals("BETWEEN")) {
			if (columnValues.size() == 2) {
				finalColVal = columnValues.get(0) + " AND " + columnValues.get(1);
			} else {
				throw new QueryMalformedException("Where condition values are greater than or less than 2");
			}
		}
		if (whereClauseOperator.equals("LIKE")) {
			if (columnValues.size() == 1) {
				finalColVal = StringUtils.wrap(columnValues.get(0), "\'");
			} else {
				throw new QueryMalformedException("Where condition pattern error");
			}
		}
		return finalColVal;
	}

	/**
	 * @return where condition appender - and, or, not
	 */
	private static String getCndtnAppndr(String conditionAppender) {
		StringBuilder cndString = new StringBuilder();
		if (conditionAppender != null && !(conditionAppender.isEmpty()) && !(conditionAppender.isBlank())) {
			cndString.append(QueryConstants.SINGLE_SPACE);
			cndString.append(conditionAppender);
			cndString.append(QueryConstants.SINGLE_SPACE);
		}
		return cndString.toString();
	}

	/**
	 * @return select phrase with columns, table names, where & group by condition
	 */
	public static String getSlctQryWithWhrGrpBy(QryWithWhrGrpBy queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		SelectionColumns columns = new SelectionColumns(queryParams.getSelectionColumns());
		tempQuery.append(getSlctQry(columns));
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(getWhereClause(queryParams.getWhereConditions()));
		tempQuery.append(getGrpByCndn(queryParams.getGroupByConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return group by phrase for parent method call
	 */
	private static Object getGrpByCndn(List<GroupByConditionParameters> groupByConditions) {
		StringBuilder grpBySb = new StringBuilder();
		for (GroupByConditionParameters groupByConditionParameter : groupByConditions) {
			if (grpBySb != null && grpBySb.length() > 0) {
				grpBySb.append(",");
			}
			grpBySb.append(groupByConditionParameter.getTableName()).append(QueryConstants.DOT_OPERATOR)
					.append(groupByConditionParameter.getColumnName());
		}
		return QueryConstants.GRPBY_PHRASE + grpBySb.toString();
	}

	/**
	 * @return select phrase with columns, table names, where & order by condition
	 */
	public static String getSlctQryWithWhrOrdrBy(QryWithWhrOrdrBy queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		SelectionColumns columns = new SelectionColumns(queryParams.getSelectionColumns());
		tempQuery.append(getSlctQry(columns));
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(getWhereClause(queryParams.getWhereConditions()));
		tempQuery.append(getOrdrByCndn(queryParams.getOrderByConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return order by phrase - called from parent method
	 */
	private static Object getOrdrByCndn(List<OrderByConditionParameters> orderByConditions) {
		StringBuilder ordrBySb = new StringBuilder();
		for (OrderByConditionParameters orderByConditionParameter : orderByConditions) {
			if (ordrBySb != null && ordrBySb.length() > 0) {
				ordrBySb.append(",");
			}
			ordrBySb.append(orderByConditionParameter.getTableName()).append(QueryConstants.DOT_OPERATOR)
					.append(orderByConditionParameter.getColumnName()).append(QueryConstants.SINGLE_SPACE)
					.append(OrderByCondition.contains((orderByConditionParameter.getOrder())));
		}
		return QueryConstants.ORDRBY_PHRASE + ordrBySb.toString();
	}

	/**
	 * @return select phrase with columns, table names, where, group by & order by
	 *         condition
	 */
	public static String getSlctQryWithWhrGrpByOrdrBy(QryWithWhrGrpByOrdrBy queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		SelectionColumns columns = new SelectionColumns(queryParams.getSelectionColumns());
		tempQuery.append(getSlctQry(columns));
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(getWhereClause(queryParams.getWhereConditions()));
		tempQuery.append(getGrpByCndn(queryParams.getGroupByConditions()));
		tempQuery.append(getOrdrByCndn(queryParams.getOrderByConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return select phrase with columns, table names for join condition
	 */
	public static String getSelectQueryForJoin(SelectionColumns queryParams) {

		List<SelectionColumn> columns = queryParams.getSelectionColumns();

		StringBuilder sbColumns = new StringBuilder();
		for (SelectionColumn selectColumn : columns) {
			if (selectColumn.getColumnNames() == null || selectColumn.getColumnNames().size() == 0) {
				sbColumns.append("*");
			} else {
				for (String column : selectColumn.getColumnNames()) {
					if (sbColumns != null && sbColumns.length() > 0) {
						sbColumns.append(",");
					}
					sbColumns.append(selectColumn.getTableName()).append(QueryConstants.DOT_OPERATOR).append(column);
				}
			}
		}
		StringBuilder tempQuery = new StringBuilder();
		tempQuery.append(QueryConstants.SELECT_PHRASE);
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(sbColumns);
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		tempQuery.append(QueryConstants.FROM_PHRASE);
		tempQuery.append(QueryConstants.SINGLE_SPACE);
		return tempQuery.toString();
	}

	/**
	 * @return select phrase with columns, table names & join condition
	 */
	public static String getSlctQryWithJoin(QryWithJoin queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		SelectionColumns columns = new SelectionColumns(queryParams.getSelectionColumns());
		tempQuery.append(getSelectQueryForJoin(columns));
		tempQuery.append(getJoinCond(queryParams.getJoinConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return join condition phrase - called from parent method
	 */
	private static String getJoinCond(List<JoinConditionParameters> joinConditions) {
		StringBuilder tempQuery = new StringBuilder();
		int counter = 1;
		for (JoinConditionParameters joinConditionParameters : joinConditions) {
			if (counter == 1) {
				tempQuery.append(joinConditionParameters.getLefttableName());
			}
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(JoinTypes.contains(joinConditionParameters.getJointype()));
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(joinConditionParameters.getRighttableName());
			tempQuery.append(QueryConstants.ON);
			tempQuery.append(joinConditionParameters.getLefttableName()).append(QueryConstants.DOT_OPERATOR)
					.append(joinConditionParameters.getLeftcolumnName());
			tempQuery.append(QueryConstants.EQUALTO);
			tempQuery.append(joinConditionParameters.getRighttableName()).append(QueryConstants.DOT_OPERATOR)
					.append(joinConditionParameters.getRightcolumnName());
			counter++;
		}
		return tempQuery.toString();
	}

	/**
	 * @return select phrase with columns, table names, join & where condition
	 */
	public static String getSlctQryWithJoinWhr(QryWithJoinWhr queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		QryWithJoin qryWithJoin = new QryWithJoin(queryParams.getSelectionColumns(), queryParams.getJoinConditions());
		tempQuery.append(getSlctQryWithJoin(qryWithJoin));
		tempQuery.append(getWhereClause(queryParams.getWhereConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return select phrase with columns, table names, join, where & group by
	 *         condition
	 */
	public static String getSlctQryWithJoinWhrGrpBy(QryWithJoinWhrGrpBy queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		QryWithJoinWhr qryWithJoinWhr = new QryWithJoinWhr(queryParams.getSelectionColumns(),
				queryParams.getJoinConditions(), queryParams.getWhereConditions());
		tempQuery.append(getSlctQryWithJoinWhr(qryWithJoinWhr));
		tempQuery.append(getGrpByCndn(queryParams.getGroupByConditions()));
		return tempQuery.toString();
	}

	/**
	 * @return select phrase with columns, table names, join, where, group by &
	 *         order by condition
	 */
	public static String getSlctQryWithJoinWhrGrpByOrdrBy(QryWithJoinWhrGrpByOrdrBy queryParams) {
		StringBuilder tempQuery = new StringBuilder();
		QryWithJoinWhrGrpBy qryWithJoinWhrGrpBy = new QryWithJoinWhrGrpBy(queryParams.getSelectionColumns(),
				queryParams.getJoinConditions(), queryParams.getWhereConditions(), queryParams.getGroupByConditions());
		tempQuery.append(getSlctQryWithJoinWhrGrpBy(qryWithJoinWhrGrpBy));
		tempQuery.append(getOrdrByCndn(queryParams.getOrderByConditions()));
		return tempQuery.toString();
	}

}
