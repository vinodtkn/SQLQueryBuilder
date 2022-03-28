package com.sqlquerybuilder.SQLQueryBuilder.dto;

import org.springframework.stereotype.Component;

/**
 * Class to define Join Condition Parameters
 */
@Component
public class JoinConditionParameters {

	private String jointype;
	private String lefttableName;
	private String leftcolumnName;
	private String righttableName;
	private String rightcolumnName;

	/**
	 * 
	 */
	public JoinConditionParameters() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param jointype
	 * @param lefttableName
	 * @param leftcolumnName
	 * @param righttableName
	 * @param rightcolumnName
	 */
	public JoinConditionParameters(String jointype, String lefttableName, String leftcolumnName, String righttableName,
			String rightcolumnName) {
		super();
		this.jointype = jointype;
		this.lefttableName = lefttableName;
		this.leftcolumnName = leftcolumnName;
		this.righttableName = righttableName;
		this.rightcolumnName = rightcolumnName;
	}

	/**
	 * @return the jointype
	 */
	public String getJointype() {
		return jointype;
	}

	/**
	 * @param jointype the jointype to set
	 */
	public void setJointype(String jointype) {
		this.jointype = jointype;
	}

	/**
	 * @return the lefttableName
	 */
	public String getLefttableName() {
		return lefttableName;
	}

	/**
	 * @param lefttableName the lefttableName to set
	 */
	public void setLefttableName(String lefttableName) {
		this.lefttableName = lefttableName;
	}

	/**
	 * @return the leftcolumnName
	 */
	public String getLeftcolumnName() {
		return leftcolumnName;
	}

	/**
	 * @param leftcolumnName the leftcolumnName to set
	 */
	public void setLeftcolumnName(String leftcolumnName) {
		this.leftcolumnName = leftcolumnName;
	}

	/**
	 * @return the righttableName
	 */
	public String getRighttableName() {
		return righttableName;
	}

	/**
	 * @param righttableName the righttableName to set
	 */
	public void setRighttableName(String righttableName) {
		this.righttableName = righttableName;
	}

	/**
	 * @return the rightcolumnName
	 */
	public String getRightcolumnName() {
		return rightcolumnName;
	}

	/**
	 * @param rightcolumnName the rightcolumnName to set
	 */
	public void setRightcolumnName(String rightcolumnName) {
		this.rightcolumnName = rightcolumnName;
	}

}
