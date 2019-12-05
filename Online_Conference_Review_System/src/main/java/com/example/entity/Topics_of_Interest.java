package com.example.entity;

public class Topics_of_Interest {
	String topic;
	String email;
	
	
	public Topics_of_Interest(String topic, String email) {
		super();
		this.topic = topic;
		this.email = email;
	}
	
	public Topics_of_Interest()
	{
		this.topic="";
		this.email="";
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
