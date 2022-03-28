package com.sqlquerybuilder.SQLQueryBuilder.constants;

import org.apache.commons.lang3.StringUtils;

import com.sqlquerybuilder.SQLQueryBuilder.errorhandler.QueryMalformedException;

/**
 * enum class to define join types such as inner join, left outer join, etc..
 */
public enum JoinTypes {
	INNERJOIN("INNER JOIN"), LEFTJOIN("LEFT JOIN"), RIGHTJOIN("RIGHT JOIN"), FULLOUTERJOIN("FULL OUTER JOIN");

	private String joinType;

	public String getJoinType() {
		return this.joinType;
	}

	private JoinTypes(String joinType) {
		this.joinType = joinType;
	}

	/**
	 * checks if the given input matches with the enum values else throws exception
	 */
	public static String contains(String test) {

		for (JoinTypes c : JoinTypes.values()) {
			if (c.name().equals(StringUtils.deleteWhitespace(test))) {
				return c.getJoinType();
			}
		}
		throw new QueryMalformedException("Join Type mismatch");
	}

}
