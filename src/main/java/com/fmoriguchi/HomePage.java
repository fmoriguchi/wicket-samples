package com.fmoriguchi;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.fmoriguchi.wicket.components.message.Alert;
import com.fmoriguchi.wicket.components.message.Alert.Type;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
        add(new Alert("alert", Model.of(getApplication().getFrameworkSettings().getVersion()), Type.INFO));
    }
}
