/**
 * 
 */
package com.fmoriguchi.examples.repeater.refreshingview;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.fmoriguchi.wicket.resource.bootstrap.BootstrapThemeResource;

/**
 * @author fabio
 *
 */
public final class NoteView extends Panel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WebMarkupContainer container;
	private Component id;
	private Component title;
	private Component description;
	private IModel<Note> itemFound;

	/**
	 * 
	 * @param id
	 * @param model
	 */
	public NoteView(String id, IModel<Note> model) {
		super(id, model);
		
		this.itemFound = model;
		
		this.container = new WebMarkupContainer("note") {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onComponentTag(ComponentTag tag) {
			
				super.onComponentTag(tag);
				
				tag.put("class", "alert alert-success");
			}
		};
		this.id = newId("code");
		this.title = newTitle("title");
		this.description = newDescription("description");
		
		container.add(this.id);
		container.add(this.title);
		container.add(this.description);
		
		add(container);
		
		setOutputMarkupId(true);
	}
	
	private Component newId(String id) {
		
		return new Label(id, this.itemFound.getObject().getId());
	}
	
	private Component newTitle(String id) {
		
		return new Label(id, this.itemFound.getObject().getTitle());
	}
	
	private Component newDescription(String id) {
		
		return new Label(id, this.itemFound.getObject().getDescription());
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
	
		super.renderHead(response);
		
		response.render(CssHeaderItem.forReference(BootstrapThemeResource.get()));
	}

}
