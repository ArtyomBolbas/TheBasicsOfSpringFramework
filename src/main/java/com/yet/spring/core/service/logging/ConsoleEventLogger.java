package com.yet.spring.core.service.logging;

import com.yet.spring.core.model.Event;

public class ConsoleEventLogger implements EventLogger{

	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

}
