package com.yet.spring.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

	private int id;
	private String message;
	private Date date;
	private DateFormat df;
	
	private Random generator = new Random();
	
	public Event(Date date, DateFormat df) {
		super();
		this.id = generator.nextInt();
		this.date = date;
		this.df = df;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "id=" + id + ", message=" + message + ", date=" + df.format(date);
	}

}
