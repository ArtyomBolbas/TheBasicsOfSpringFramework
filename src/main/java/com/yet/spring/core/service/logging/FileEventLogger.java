package com.yet.spring.core.service.logging;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.yet.spring.core.model.Event;

public class FileEventLogger implements EventLogger{

	private File file;
	private String fileName;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}
	
	public void init() {
		this.file = new File(fileName);
		if (file.exists() && !file.canWrite()) {
			throw new IllegalArgumentException("Can't write to file " + fileName);
		} else if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new IllegalArgumentException("Can't create file " + e);
			}
		}
	}
	
	@Override
	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.toString(), "UTF-8", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
