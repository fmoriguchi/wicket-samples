/**
 * 
 */
package com.fmoriguchi.wicket.resource.bootstrap;

import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * @author fabio
 *
 */
public final class BootstrapResource extends CssResourceReference {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static final String CSS = "css/bootstrap.min.css";
	
	/**
	 * 
	 */
	private static final ResourceReference RESOURCE = new BootstrapResource();  
	
	/**
	 * 
	 */
	private BootstrapResource() {
		
		super(BootstrapResource.class, CSS);
	}

	/**
	 * 
	 * @return
	 */
	public static final ResourceReference get() {
		
		return RESOURCE;
	}

}
