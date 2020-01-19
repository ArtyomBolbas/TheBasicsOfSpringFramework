package com.yet.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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

		((ClassPathXmlApplicationContext)ctx).close();
		
		app.logEvent("Some event for user 1");
		app.logEvent("Some event for user 2");
	}

	private void logEvent(String msg) {
		String message = msg.replaceAll(client.getId(), client.getFullName());
		eventLogger.logEvent(message);
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
