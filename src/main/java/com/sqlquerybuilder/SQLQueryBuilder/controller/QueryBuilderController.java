package com.sqlquerybuilder.SQLQueryBuilder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlquerybuilder.SQLQueryBuilder.dto.SelectionColumns;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoin;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoinWhr;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoinWhrGrpBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithJoinWhrGrpByOrdrBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhr;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhrGrpBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhrGrpByOrdrBy;
import com.sqlquerybuilder.SQLQueryBuilder.parser.QryWithWhrOrdrBy;
import com.sqlquerybuilder.SQLQueryBuilder.utils.QueryBuilderUtils;

/**
 * class to define all the api endpoints for query builder
 */
@RestController
public class QueryBuilderController {

	private String query;

	/**
	 * generates query with only selection parameters and table name
	 */
	@PostMapping(path = "/select", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQuery(@RequestBody SelectionColumns queryParams) {
		query = QueryBuilderUtils.getSlctQry(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name and where condition
	 */
	@PostMapping(path = "/selectwithwhere", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithWhereCondition(@RequestBody QryWithWhr queryParams) {
		query = QueryBuilderUtils.getSlctQryWithWhr(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name, where condition &
	 * group by clause
	 */
	@PostMapping(path = "/selectwithwhereandgroupby", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithWhereAndGroupByCondition(@RequestBody QryWithWhrGrpBy queryParams) {
		query = QueryBuilderUtils.getSlctQryWithWhrGrpBy(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name, where condition &
	 * order by clause
	 */
	@PostMapping(path = "/selectwithwhereandorderby", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithWhereAndOrderByCondition(@RequestBody QryWithWhrOrdrBy queryParams) {
		query = QueryBuilderUtils.getSlctQryWithWhrOrdrBy(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name, where condition, group
	 * by & order by clause
	 */
	@PostMapping(path = "/selectwithwheregroupbyandorderby", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithWhereGroupByAndOrderByCondition(@RequestBody QryWithWhrGrpByOrdrBy queryParams) {
		query = QueryBuilderUtils.getSlctQryWithWhrGrpByOrdrBy(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name & join condition
	 */
	@PostMapping(path = "/selectwithjoin", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithJoin(@RequestBody QryWithJoin queryParams) {
		query = QueryBuilderUtils.getSlctQryWithJoin(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name, join & where
	 * conditions
	 */
	@PostMapping(path = "/selectwithjoinandwhere", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithJoinAndWhereCondition(@RequestBody QryWithJoinWhr queryParams) {
		query = QueryBuilderUtils.getSlctQryWithJoinWhr(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name, join, where & group by
	 * conditions
	 */
	@PostMapping(path = "/selectwithjoinwhereandgroupby", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithJoinWhereAndGroupbyCondition(@RequestBody QryWithJoinWhrGrpBy queryParams) {
		query = QueryBuilderUtils.getSlctQryWithJoinWhrGrpBy(queryParams);
		return query;
	}

	/**
	 * generates query with selection parameters, table name, join, where, group by
	 * & order by conditions
	 */
	@PostMapping(path = "/selectwithjoinwheregroupbyandorderby", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSelectQueryWithJoinWhereGroupbyAndOrderByCondition(
			@RequestBody QryWithJoinWhrGrpByOrdrBy queryParams) {
		query = QueryBuilderUtils.getSlctQryWithJoinWhrGrpByOrdrBy(queryParams);
		return query;
	}

}
