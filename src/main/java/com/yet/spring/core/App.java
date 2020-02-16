package com.yet.spring.core;

import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.model.Client;
import com.yet.spring.core.model.Event;
import com.yet.spring.core.model.Event.EventType;
import com.yet.spring.core.service.logging.EventLogger;

public class App {

	private Client client;
	private EventLogger eventLogger;
	private Map<EventType, EventLogger> loggers;

	public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
		super();
		this.client = client;
		this.eventLogger = eventLogger;
		this.loggers = loggers;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		App app = ctx.getBean("app", App.class);
		
		Event event1 = ctx.getBean("event", Event.class);
		event1.setMessage("Hello I'm event number one");
		app.pause(2000);
		Event event2 = ctx.getBean("event", Event.class);
		event2.setMessage("Hello I'm event number two");
		app.pause(2000);
		Event event3 = ctx.getBean("event", Event.class);
		event3.setMessage("Hello I'm event number three");
		
		app.logEvent(event1, null);
		app.logEvent(event2, EventType.ERROR);
		app.logEvent(event3, EventType.INFO);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}

	private void logEvent(Event event, EventType eventType) {
		if (!Event.hasEventType(eventType)) {
			eventLogger.logEvent(event);
		} else {
			loggers.get(eventType).logEvent(event);
		}
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
