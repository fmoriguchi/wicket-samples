/**
 * 
 */
package com.fmoriguchi.examples.repeater.refreshingview;

import java.io.Serializable;

/**
 * @author fabio
 *
 */
public final class Note implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private final String title;
	private final String description;
	/**
	 * @param title
	 * @param description
	 */
	public Note(String title, String description) {
		
		this.title = title;
		this.description = description;
	}
	
	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}



	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}
	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}
	
	

}
