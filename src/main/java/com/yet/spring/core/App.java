package com.yet.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		App app = (App) ctx.getBean("app");
		Event event1 = (Event)ctx.getBean("event");
		//The example shows a different time between events  
		for(long i = 0; i < 100000000;i++) {
			for(long y = 0; y < 10; y++) {
			}
		}
		Event event2 = (Event)ctx.getBean("event");
		
		((ClassPathXmlApplicationContext)ctx).close();
		
		app.logEvent(event1);
		app.logEvent(event2);
	}

	private void logEvent(Event event) {
		eventLogger.logEvent(event);
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
