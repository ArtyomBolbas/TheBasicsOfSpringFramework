package com.yet.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.model.Client;
import com.yet.spring.core.model.Event;
import com.yet.spring.core.service.logging.EventLogger;

public class App {

	private Client client;
	private EventLogger eventLogger;

	public App(Client client, EventLogger eventLogger) {
		super();
		this.client = client;
		this.eventLogger = eventLogger;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		App app = ctx.getBean("app", App.class);
		
		Event event1 = ctx.getBean("event", Event.class);
		app.pause(2000);
		Event event2 = ctx.getBean("event", Event.class);
		app.pause(2000);
		Event event3 = ctx.getBean("event", Event.class);
		
		app.logEvent(event1);
		app.logEvent(event2);
		app.logEvent(event3);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}

	private void logEvent(Event event) {
		eventLogger.logEvent(event);
	}
	
	private void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EventLogger getEventLogger() {
		return eventLogger;
	}

	public void setEventLogger(EventLogger eventLogger) {
		this.eventLogger = eventLogger;
	}

}
