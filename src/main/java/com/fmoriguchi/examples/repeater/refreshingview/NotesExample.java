/**
 * 
 */
package com.fmoriguchi.examples.repeater.refreshingview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author fabio
 *
 */
public final class NotesExample extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final transient NotesRepository repository = NotesRepository.get();
	
	private final Collection<IModel<Note>> founds = new ArrayList<IModel<Note>>();
	
	private final WebMarkupContainer container;
	
	private final Component items;
	
	private final Component showMoreResults;
	
	private Integer start = 0;
	
	private Integer size = 10;
	
	/**
	 * 
	 */
	public NotesExample() {
		
		container = new WebMarkupContainer("container");
		container.setOutputMarkupId(true);

		showMoreResults = newShowMoreResults("add");
	
		items = newItems("items");
	
		container.add(items);
				
		add(container);
		add(showMoreResults);
	}
	
	@Override
	protected void onInitialize() {
	
		super.onInitialize();
		
		loadNotes();
	}
	
	/**
	 * 
	 */
	private void loadNotes() {
		
		Collection<Note> notes = repository.allNotes(start, size);
		
		if (notes.isEmpty()) {
			
			showMoreResults.setVisible(false);
			
			return;
		}
		
		showMoreResults.setVisible(true);
		
		for (Note note : notes) {
			
			founds.add(Model.of(note));
		}
		
		start = start + 10;
		size = size + 10;
	}
	
	private Component newItems(String id) {
		
		return new RefreshingView<Note>(id) {

			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<IModel<Note>> getItemModels() {
				
				return founds.iterator();
			}

			@Override
			protected void populateItem(Item<Note> item) {
				
				item.add(new NoteView("item", item.getModel()));		
				
			}
		}.setOutputMarkupId(true);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	private Component newShowMoreResults(String id) {
		
		return new AjaxLink<Void>(id) {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				
				loadNotes();
				
				target.add(container);
				target.add(this);
			}
		};
	}

}
