package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define Join Condition Parameters
 */
@Component
public class JoinConditionParameters {

	private String joinType;
	private String primaryTableColumnName;
	private String secondaryTableAliasName;
	private String secondaryTableColumnName;

	/**
	 * 
	 */
	public JoinConditionParameters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JoinConditionParameters(String joinType, String primaryTableColumnName, String secondaryTableAliasName,
			String secondaryTableColumnName) {
		super();
		this.joinType = joinType;
		this.primaryTableColumnName = primaryTableColumnName;
		this.secondaryTableAliasName = secondaryTableAliasName;
		this.secondaryTableColumnName = secondaryTableColumnName;
	}

	public String getJoinType() {
		return joinType;
	}

	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}

	public String getPrimaryTableColumnName() {
		return primaryTableColumnName;
	}

	public void setPrimaryTableColumnName(String primaryTableColumnName) {
		this.primaryTableColumnName = primaryTableColumnName;
	}

	public String getSecondaryTableAliasName() {
		return secondaryTableAliasName;
	}

	public void setSecondaryTableAliasName(String secondaryTableAliasName) {
		this.secondaryTableAliasName = secondaryTableAliasName;
	}

	public String getSecondaryTableColumnName() {
		return secondaryTableColumnName;
	}

	public void setSecondaryTableColumnName(String secondaryTableColumnName) {
		this.secondaryTableColumnName = secondaryTableColumnName;
	}

	

}
