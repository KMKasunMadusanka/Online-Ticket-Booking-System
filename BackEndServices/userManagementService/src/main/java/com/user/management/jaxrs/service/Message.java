package com.user.management.jaxrs.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Message")
public class Message {
	 private String message;
	 
	    public String getMessage() {
	     return message;
	    }
	 
	    public void setMessage(String message) {
	     this.message = message;
	    }
}
