package com.sqlquerybuilder.SQLQueryBuilder.constants;

import com.sqlquerybuilder.SQLQueryBuilder.errorhandler.QueryMalformedException;

/**
 * enum class to define where clause operatos such as =,<,<=, IN, BETWEEN,etc..
 */
public enum WhereClauseOperators {
	EQUAL("="), LESSTHAN("<"), GREATERTHAN(">"), LESSTHANOREQUAL("<="), GREATERTHANOREQUAL(">="), NOTEQUAL("<>"),
	BETWEEN("BETWEEN"), LIKE("LIKE"), IN("IN");

	private String operator;

	public String getOperator() {
		return this.operator;
	}

	private WhereClauseOperators(String operator) {
		this.operator = operator;
	}

	/**
	 * checks if the given input matches with the enum values else throws exception
	 */
	public static String contains(String test) {

		for (WhereClauseOperators c : WhereClauseOperators.values()) {
			if (c.name().equals(test)) {
				return c.getOperator();
			}
		}
		throw new QueryMalformedException("Where Clause Operator mismatch");
	}

}
