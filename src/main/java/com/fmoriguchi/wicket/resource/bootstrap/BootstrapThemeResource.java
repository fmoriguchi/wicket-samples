/**
 * 
 */
package com.fmoriguchi.wicket.resource.bootstrap;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * @author fabio
 *
 */
public final class BootstrapThemeResource extends CssResourceReference {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static final String CSS = "css/bootstrap-theme.min.css";
	
	/**
	 * 
	 */
	private static final ResourceReference RESOURCE = new BootstrapThemeResource();
	
	/**
	 * 
	 */
	private BootstrapThemeResource() {
		
		super(BootstrapThemeResource.class, CSS);
	}
	
	@Override
	public Iterable<? extends HeaderItem> getDependencies() {
	
		Collection<HeaderItem> dependencies = new ArrayList<HeaderItem>();
		
		dependencies.add(CssHeaderItem.forReference(BootstrapResource.get()));
		
		return dependencies;
	}
	
	public static final ResourceReference get() {
		
		return RESOURCE;
	}

}
