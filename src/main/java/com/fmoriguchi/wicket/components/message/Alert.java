/**
 * 
 */
package com.fmoriguchi.wicket.components.message;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import com.fmoriguchi.wicket.resource.bootstrap.BootstrapThemeResource;

/**
 * @author fabio
 *
 */
public class Alert extends WebMarkupContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum Type {
		
		INFO("alert alert-info"),
		SUCCESS("alert alert-success"),
		WARNING("alert alert-warning"),
		DANGER("alert alert-danger");
		
		protected final String style;
		
		/**
		 * 
		 * @param style
		 */
		private Type(String style) {
			
			this.style = style;
		}
		
	}

	private final Type type;
	
	/**
	 * 
	 * @param id
	 * @param message
	 * @param type
	 */
	public Alert(String id, IModel<String> message, Type type) {
		
		super(id, message);
		
		this.type = type;
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {

		checkComponentTag(tag, "div");
		tag.put("class", this.type.style);
		
		super.onComponentTag(tag);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
	
		getResponse().write(getDefaultModelObjectAsString());
		
		super.onComponentTagBody(markupStream, openTag);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
	
		super.renderHead(response);
		
		response.render(CssHeaderItem.forReference(BootstrapThemeResource.get()));
	}
}
