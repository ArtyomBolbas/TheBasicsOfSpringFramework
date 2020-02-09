package com.yet.spring.core.service.logging;

import java.util.ArrayList;

import java.util.List;

import com.yet.spring.core.model.Event;

public class CacheFileEventLogger extends FileEventLogger{

	private int cacheSize;
	private List<Event> cache;
	
	public CacheFileEventLogger(String fileName, int cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;
		this.cache = new ArrayList<>(cacheSize);
	}
	
	@Override
	public void logEvent(Event event) {
		cache.add(event);
		if (cache.size() == cacheSize) {
			writeEventFromCache();
			cache.clear();
		}
	}

	public void destroy() {
		if (!cache.isEmpty()) {
			writeEventFromCache();
		}
	}
	
	private void writeEventFromCache() {
		cache.stream().forEach(super::logEvent);
	}
	
}
