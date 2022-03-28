package com.sqlquerybuilder.SQLQueryBuilder.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * class to contain list of selection classes
 */
@Component
public class SelectionColumns {

	private List<SelectionColumn> selectionColumns;

	/**
	 * 
	 */
	public SelectionColumns() {
		super();
	}

	/**
	 * @param selectionColumns
	 */
	public SelectionColumns(List<SelectionColumn> selectionColumns) {
		super();
		this.selectionColumns = selectionColumns;
	}

	/**
	 * @return the selectionColumns
	 */
	public List<SelectionColumn> getSelectionColumns() {
		return selectionColumns;
	}

	/**
	 * @param selectionColumns the selectionColumns to set
	 */
	public void setSelectionColumns(List<SelectionColumn> selectionColumns) {
		this.selectionColumns = selectionColumns;
	}

	

}
