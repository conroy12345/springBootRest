package com.rest.application.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataSource {
	private static MyDataSource instance;
	
	
public static  MyDataSource getInstance() {
	instance = new MyDataSource();
		return instance;
	}
	
private MyDataSource() {
	
}
public static	Connection getConnection() {
	Connection connect=null;

try {
	connect=DriverManager.getConnection(ConnectionEnum.URL.toString(),
			ConnectionEnum.USERNAME.toString(),ConnectionEnum.PASSWORD.toString());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return connect;
		
	}

public PreparedStatement createQuery(String sql) {
	PreparedStatement pst=null;
	
	try {
		pst=getConnection().prepareStatement(sql);
	} catch (SQLException e) {
		System.out.println(e.getMessage());;
	}
	return pst;
}

public Statement createStatement() {
	Statement  statement= null;
	try {
		statement=getConnection().createStatement();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return statement;
	
}
}
