package com.sqlquerybuilder.SQLQueryBuilder.constants;

import com.sqlquerybuilder.SQLQueryBuilder.errorhandler.QueryMalformedException;

/**
 * enum class to contain the utils for defining where clause combinations - and,
 * or, not
 */
public enum WhereClauseCombinations {
	AND("AND"), OR("OR"), NOT("NOT");

	private String combination;

	public String getCombination() {
		return this.combination;
	}

	private WhereClauseCombinations(String combination) {
		this.combination = combination;
	}

	/**
	 * checks if the given input matches with the enum values else throws exception
	 */
	public static String contains(String test) {

		if (test.isBlank() || test.isEmpty()) {
			return "";
		}

		for (WhereClauseCombinations c : WhereClauseCombinations.values()) {
			if (c.name().equals(test)) {
				return c.getCombination();
			}
		}
		throw new QueryMalformedException("Where Clause Appender mismatch");
	}

}
