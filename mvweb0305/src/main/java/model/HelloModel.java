package model;

import java.util.HashMap;
import java.util.Map;

public class HelloModel {
	private Map<String, String> messages;
	
	public HelloModel() {
		super();
		// TODO Auto-generated constructor stub
		messages = new HashMap<String,String>();
		messages.put("John","Hello");
		messages.put("Mary","Hello");
		messages.put("Vincent","Hello");
		
	}

	public HelloModel(Map<String, String> messages) {
		super();
		this.messages = messages;
	}

	public String sayHello(String user) {
		String message = messages.get(user);
		return message + ", "+user+"!";
	}
}
