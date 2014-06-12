package com.fmoriguchi;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.fmoriguchi.examples.ajax.ClickCounterExample;
import com.fmoriguchi.examples.repeater.refreshingview.NotesExample;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.fmoriguchi.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		
		mountPage(ClickCounterExample.class.getSimpleName().toLowerCase(), ClickCounterExample.class);
		mountPage(NotesExample.class.getSimpleName().toLowerCase(), NotesExample.class);

		// add your configuration here
	}
}
