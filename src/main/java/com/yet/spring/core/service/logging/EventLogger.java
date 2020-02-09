package com.yet.spring.core.service.logging;

import com.yet.spring.core.model.Event;

public interface EventLogger {

	void logEvent(Event event);
	
}
