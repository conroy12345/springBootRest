package com.rest.application.jdbc.connection;

public enum ConnectionEnum {
	URL("jdbc:mysql://localhost:3306/users"),USERNAME("root"),PASSWORD("cnwl");
	String name;
	private ConnectionEnum(String name) {
		this.name=name;
	}
	
	public String toString() {
		return name;
	}
}
