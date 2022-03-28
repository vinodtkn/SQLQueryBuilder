package com.sqlquerybuilder.SQLQueryBuilder.constants;

import com.sqlquerybuilder.SQLQueryBuilder.errorhandler.QueryMalformedException;

/**
 * enum to define orderby condition - either asc or desc
 */
public enum OrderByCondition {
	ASC("ASC"), DESC("DESC");

	private String order;

	public String getOrder() {
		return this.order;
	}

	private OrderByCondition(String order) {
		this.order = order;
	}

	/**
	 * checks if the given input matches with the enum values else throws exception
	 */
	public static String contains(String test) {

		for (OrderByCondition c : OrderByCondition.values()) {
			if (c.name().equals(test)) {
				return c.getOrder();
			}
		}
		throw new QueryMalformedException("OrderByCondition mismatch");
	}

}
