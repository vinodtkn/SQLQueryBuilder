package com.sqlquerybuilder.SQLQueryBuilder.utils;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.sqlquerybuilder.SQLQueryBuilder.dto.QueryComponents;
import com.sqlquerybuilder.SQLQueryBuilder.dto.QueryParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumnParameters;
import com.sqlquerybuilder.SQLQueryBuilder.dto.SubQueryDetails;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionDetails;
import com.sqlquerybuilder.SQLQueryBuilder.dto.WhereConditionParameters;
import com.sqlquerybuilder.SQLQueryBuilder.errorhandler.QueryMalformedException;

/**
 * class to contain the utils for building the SQL query
 */

@Component
public class QryBldrUtils {

	static HashMap<String, String> tableAliasMapping = new HashMap<String, String>();

	/**
	 * @return select query - contains the method calls to frame partial queries and consolidate it here
	 */
	public static String getSlctQry(QueryComponents queryComponents) {
		QueryParameters queryParameters = queryComponents.getQueryComponents();
		StringBuilder tempQuery = new StringBuilder();
		List<String> tblNames = new ArrayList<String>();
		if (null != queryParameters.getTableNames() && queryParameters.getTableNames().size() > 0) {
			tblNames = queryParameters.getTableNames();
		} else {
			throw new QueryMalformedException("Table Names are empty");
		}
		List<String> tblAliases = new ArrayList<String>();
		if (null != queryParameters.getTableAliases() && queryParameters.getTableAliases().size() > 0) {
			tblAliases = queryParameters.getTableAliases();
		} else {
			throw new QueryMalformedException("Table Aliases are empty");
		}
		List<SelectionColumnParameters> selectionColDtls = queryParameters.getSelectionColumns();
		WhereConditionDetails whrCndnDtls = queryParameters.getWhereConditions();
		List<JoinConditionParameters> joinCndnDtls = queryParameters.getJoinConditions();
		List<GroupByConditionParameters> grpByCndnDtls = queryParameters.getGroupByColumns();
		List<OrderByConditionParameters> ordrByCndnDtls = queryParameters.getOrderByConditions();

		if (tblNames.size() != tblAliases.size()) {
			throw new QueryMalformedException("Table Names & Table Aliases doesnt match");
		}

		for (int i = 0; i < tblNames.size(); i++) {
			tableAliasMapping.put(tblAliases.get(i), tblNames.get(i));
		}

		tempQuery.append(getSelectPhrase(tblNames, tblAliases, selectionColDtls, joinCndnDtls));
		if (null != joinCndnDtls && !(joinCndnDtls.isEmpty()) && joinCndnDtls.size() > 0) {
			tempQuery.append(getJoinPhrase(tblNames, tblAliases, joinCndnDtls));
		}
		if (null != whrCndnDtls && !(whrCndnDtls.getConditions().isEmpty()) && whrCndnDtls.getConditions().size() > 0) {
			tempQuery.append(getWherePhrase(tblNames, tblAliases, whrCndnDtls));
		}
		if (null != grpByCndnDtls && !(grpByCndnDtls.isEmpty()) && grpByCndnDtls.size() > 0) {
			tempQuery.append(getGrpByPhrase(tblNames, tblAliases, grpByCndnDtls));
		}
		if (null != ordrByCndnDtls && !(ordrByCndnDtls.isEmpty()) && ordrByCndnDtls.size() > 0) {
			tempQuery.append(getOrdrByPhrase(tblNames, tblAliases, ordrByCndnDtls));
		}

		return tempQuery.toString();
	}

	/**
	 * @return order by phrase to be appended in the select statement
	 */
	private static String getOrdrByPhrase(List<String> tblNames, List<String> tblAliases,
			List<OrderByConditionParameters> ordrByCndnDtls) {
		StringBuilder tempQuery = new StringBuilder();
		tempQuery.append(QueryConstants.ORDRBY_PHRASE);
		StringBuilder sqlPhrase = new StringBuilder();
		for (OrderByConditionParameters parameters : ordrByCndnDtls) {
			if (tblAliases.contains(parameters.getAlias())) {
				if (sqlPhrase != null && sqlPhrase.length() > 0) {
					sqlPhrase.append(",");
				}
				String sql = parameters.getAlias() + QueryConstants.DOT_OPERATOR + parameters.getColumn()
						+ QueryConstants.SINGLE_SPACE + OrderByCondition.contains(parameters.getOrder());
				sqlPhrase.append(sql);
			} else {
				throw new QueryMalformedException("Aliases doesnt match in Order By Condition");
			}
		}
		tempQuery.append(sqlPhrase.toString());
		return tempQuery.toString();
	}

	/**
	 * @return group by phrase to be appended in the select statement
	 */
	private static String getGrpByPhrase(List<String> tblNames, List<String> tblAliases,
			List<GroupByConditionParameters> grpByCndnDtls) {
		StringBuilder tempQuery = new StringBuilder();
		tempQuery.append(QueryConstants.GRPBY_PHRASE);
		StringBuilder sqlPhrase = new StringBuilder();
		for (GroupByConditionParameters parameters : grpByCndnDtls) {
			if (tblAliases.contains(parameters.getAlias())) {
				for (String columns : parameters.getColumns()) {
					if (sqlPhrase != null && sqlPhrase.length() > 0) {
						sqlPhrase.append(",");
					}
					String sql = parameters.getAlias() + QueryConstants.DOT_OPERATOR + columns
							+ QueryConstants.SINGLE_SPACE;
					sqlPhrase.append(sql);
				}
			} else {
				throw new QueryMalformedException("Aliases doesnt match in Group By Condition");
			}
		}
		tempQuery.append(sqlPhrase.toString());

		return tempQuery.toString();
	}

	/**
	 * @return join condition to be appended in the select statement
	 */
	private static String getJoinPhrase(List<String> tblNames, List<String> tblAliases,
			List<JoinConditionParameters> joinCndnDtls) {
		StringBuilder tempQuery = new StringBuilder();
		for (JoinConditionParameters joinConditionParameters : joinCndnDtls) {
			if (tblAliases.contains(joinConditionParameters.getSecondaryTableAliasName())) {
				String tmpQry = QueryConstants.SINGLE_SPACE + JoinTypes.contains(joinConditionParameters.getJoinType())
						+ QueryConstants.SINGLE_SPACE
						+ tableAliasMapping.get(joinConditionParameters.getSecondaryTableAliasName())
						+ QueryConstants.SINGLE_SPACE + QueryConstants.AS + QueryConstants.SINGLE_SPACE
						+ joinConditionParameters.getSecondaryTableAliasName() + QueryConstants.SINGLE_SPACE
						+ QueryConstants.ON + QueryConstants.SINGLE_SPACE + tblAliases.get(0)
						+ QueryConstants.DOT_OPERATOR + joinConditionParameters.getPrimaryTableColumnName()
						+ QueryConstants.EQUALTO + joinConditionParameters.getSecondaryTableAliasName()
						+ QueryConstants.DOT_OPERATOR + joinConditionParameters.getSecondaryTableColumnName()
						+ QueryConstants.SINGLE_SPACE;
				tempQuery.append(tmpQry);
			} else {
				throw new QueryMalformedException("Aliases doesnt match in Join Condition");
			}
		}
		return tempQuery.toString();
	}

	/**
	 * @return where clause to be appended in the select statement - includes logic for framing subquery too
	 */
	private static String getWherePhrase(List<String> tblNames, List<String> tblAliases,
			WhereConditionDetails whrCndnDtls) {
		StringBuilder tempQuery = new StringBuilder();
		StringBuilder tempWhrQuery = new StringBuilder();
		List<WhereConditionParameters> whereConditionParameters = whrCndnDtls.getConditions();
		tempQuery.append(QueryConstants.WHERE_PHRASE);
		for (WhereConditionParameters conditionParameters : whereConditionParameters) {
			if (tempWhrQuery != null && tempWhrQuery.length() > 0) {
				tempWhrQuery.append(WhereClauseCombinations.contains(whrCndnDtls.getConditionAppender()));
				tempWhrQuery.append(QueryConstants.SINGLE_SPACE);
			}
			if (conditionParameters.isComparingWithValue() && !(conditionParameters.isComparingWithColumn())
					&& !(conditionParameters.isComparingWithSubQuery())) {
				if (tblAliases.contains(conditionParameters.getComparingAlias())) {
					String cndn = conditionParameters.getComparingAlias() + QueryConstants.DOT_OPERATOR
							+ conditionParameters.getComparingColumn()
							+ WhereClauseOperators.contains(conditionParameters.getComparingOperator())
							+ StringUtils.wrap(conditionParameters.getComparingValue(), "\"")
							+ QueryConstants.SINGLE_SPACE;
					tempWhrQuery.append(cndn);
				} else {
					throw new QueryMalformedException("Aliases doesnt match in Where Condition");
				}
			} else if (!(conditionParameters.isComparingWithValue()) && conditionParameters.isComparingWithColumn()
					&& !(conditionParameters.isComparingWithSubQuery())) {
				if (tblAliases.contains(conditionParameters.getComparingAlias())
						&& tblAliases.contains(conditionParameters.getComparableTableAlias())) {
					String cndn = conditionParameters.getComparingAlias() + QueryConstants.DOT_OPERATOR
							+ conditionParameters.getComparingColumn()
							+ WhereClauseOperators.contains(conditionParameters.getComparingOperator())
							+ conditionParameters.getComparableTableAlias() + QueryConstants.DOT_OPERATOR
							+ conditionParameters.getComparableColumn() + QueryConstants.SINGLE_SPACE;
					tempWhrQuery.append(cndn);
				} else {
					throw new QueryMalformedException("Aliases doesnt match in Where Condition");
				}
			} else if (!(conditionParameters.isComparingWithValue()) && !(conditionParameters.isComparingWithColumn())
					&& conditionParameters.isComparingWithSubQuery()) {
				if (tblAliases.contains(conditionParameters.getComparingAlias())) {
					SubQueryDetails subQueryDetails = conditionParameters.getSubQueryDetails();
					QueryComponents queryComponents = new QueryComponents(subQueryDetails.getQueryComponents());
					String qry = conditionParameters.getComparingAlias() + QueryConstants.DOT_OPERATOR
							+ conditionParameters.getComparingColumn()
							+ WhereClauseOperators.contains(conditionParameters.getComparingOperator())
							+ QueryConstants.SINGLE_SPACE + "(" + getSlctQry(queryComponents) + ")"
							+ QueryConstants.SINGLE_SPACE;
					tempWhrQuery.append(qry);
				} else {
					throw new QueryMalformedException("Aliases doesnt match in Where Condition");
				}
			} else {
				throw new QueryMalformedException("Where condition parameters are malformed");
			}
		}
		tempQuery.append(tempWhrQuery.toString());
		return tempQuery.toString();
	}

	/**
	 * @return select phrase to be appended in the select statement
	 */
	private static String getSelectPhrase(List<String> tblNames, List<String> tblAliases,
			List<SelectionColumnParameters> selectionColDtls, List<JoinConditionParameters> joinCndnDtls) {
		StringBuilder tempQuery = new StringBuilder();
		if (null != selectionColDtls && !(selectionColDtls.isEmpty()) && selectionColDtls.size() > 0) {
			StringBuilder sqlPhrase = new StringBuilder();
			for (SelectionColumnParameters slcnCols : selectionColDtls) {
				if (tblAliases.contains(slcnCols.getAlias())) {
					for (String columns : slcnCols.getColumns()) {
						if (sqlPhrase != null && sqlPhrase.length() > 0) {
							sqlPhrase.append(",");
						}
						String sql = slcnCols.getAlias() + QueryConstants.DOT_OPERATOR + columns
								+ QueryConstants.SINGLE_SPACE;
						sqlPhrase.append(sql);

					}
				} else {
					throw new QueryMalformedException("Alias not present in the parent Alias List");
				}
			}

			StringBuilder tblWthAlias = new StringBuilder();
			for (int i = 0; i < tblNames.size(); i++) {
				if (tblWthAlias != null && tblWthAlias.length() > 0) {
					tblWthAlias.append(",");
				}
				String tblAls = tblNames.get(i) + QueryConstants.SINGLE_SPACE + QueryConstants.AS
						+ QueryConstants.SINGLE_SPACE + tblAliases.get(i);
				tblWthAlias.append(tblAls);
				if (null != joinCndnDtls && joinCndnDtls.size() > 0) {
					break;
				}
			}

			tempQuery.append(QueryConstants.SELECT_PHRASE);
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(sqlPhrase.toString());
			tempQuery.append(QueryConstants.FROM_PHRASE);
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(tblWthAlias.toString());
		} else if (tblNames.size() == 1) {
			tempQuery.append(QueryConstants.SELECT_PHRASE);
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(QueryConstants.STAR);
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(QueryConstants.FROM_PHRASE);
			tempQuery.append(QueryConstants.SINGLE_SPACE);
			tempQuery.append(tblNames.get(0));
		} else {
			throw new QueryMalformedException("Selection Columns are empty");
		}
		return tempQuery.toString();

	}

}
