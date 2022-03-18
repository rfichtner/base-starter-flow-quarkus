
package com.example.starter.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.flow.server.VaadinSession;


public class SessionStore
{
	private static final String SESSION_STORE = "sessionStore";
	
	private final List<String> entries = new ArrayList<>();
	
	public static SessionStore getOrCreate()
	{
		final VaadinSession vaadinSession = VaadinSession.getCurrent();
		final SessionStore  inSession     = (SessionStore)vaadinSession.getAttribute(SessionStore.SESSION_STORE);
		if(inSession == null)
		{
			final SessionStore newStore = new SessionStore();
			vaadinSession.setAttribute(SessionStore.SESSION_STORE, newStore);
			return newStore;
		}
		return inSession;
	}
	
	public void addEntry(final String entry)
	{
		this.entries.add(entry);
	}
	
	public String getEntries()
	{
		return this.entries.stream().collect(Collectors.joining(", <br/>"));
	}

}
