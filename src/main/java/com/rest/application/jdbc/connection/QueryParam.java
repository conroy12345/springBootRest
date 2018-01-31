package com.rest.application.jdbc.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rest.application.model.User;


public class QueryParam {
	static MyDataSource connect=MyDataSource.getInstance();
	
	public static List<User>fingAll(){		
		
		List<User>users= new ArrayList<User>();
		//User user = new User();
		Statement stat=connect.createStatement();
		ResultSet result=null;
		try {
			result=stat.executeQuery("SELECT* FROM USERS");
		while (result.next()){
		users.add(new User(result.getInt("id"),result.getString("username"),result.getString("password"),result.getString("placeOfBirth")));
		
		}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return users;
	}
	
	public static User saveUser(User user) {
		PreparedStatement pst = connect.createQuery("INSERT INTO usertable (ID,NAME,ADDRESS) VALUES(?,?,?,?)");
		try {
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getAddress());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
		
	}
	
	public static User getById(User user,int id){
		
		PreparedStatement pst = connect.createQuery("SELECT* from usertable  WHERE ID =?");
		try {
			pst.setInt(1, 1);
		
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));
			user.setPlaceOfBirth(rs.getString("PLACE_OF_BIRTH "));
			System.out.println(user);
		}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		return user;
	}
	
public static User getByName(User user,String name){		
		PreparedStatement pst = connect.createQuery("SELECT* from usertable  WHERE name =?");
		try {
			pst.setString(1, name);
		
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));
			user.setPlaceOfBirth(rs.getString("PLACE_OF_BIRTH "));
			System.out.println(user);
		}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		return user;
	}
		
	
}
