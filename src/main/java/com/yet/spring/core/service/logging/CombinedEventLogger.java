package com.yet.spring.core.service.logging;

import java.util.List;

import com.yet.spring.core.model.Event;

public class CombinedEventLogger implements EventLogger{

	List<EventLogger> loggers;
	
	public CombinedEventLogger(List<EventLogger> loggers) {
		this.loggers = loggers;
	}
	
	@Override
	public void logEvent(Event event) {
		loggers.stream().forEach(logger -> logger.logEvent(event));
	}
	
}
