package com.fmoriguchi.examples.ajax;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class ClickCounterExample extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClickCounterExample() {

		final ClickCounterLabel clickCounterLabel = new ClickCounterLabel("clickCounterLabel", "Click on me!");
		final Label clickCounter = new Label("clickCounter", new PropertyModel<String>(clickCounterLabel, "clickCounter"));
		clickCounterLabel.setOutputMarkupId(true);
		clickCounterLabel.add(new AjaxEventBehavior("click") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				clickCounterLabel.clickCounter++;
				target.add(clickCounter);
			}

		});
		add(clickCounterLabel);
		add(clickCounter.setOutputMarkupId(true));
	}
}

class ClickCounterLabel extends Label {

	private static final long serialVersionUID = 1L;
	public int clickCounter;

	public ClickCounterLabel(String id) {
		super(id);
	}

	public ClickCounterLabel(String id, IModel<?> model) {
		super(id, model);
	}

	public ClickCounterLabel(String id, String label) {
		super(id, label);
	}
}
