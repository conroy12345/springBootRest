package com.rest.application.repository;

import java.util.List;

import org.hibernate.Query;

import com.rest.application.model.User;


public interface UserRepository {
	
	public User getById(int id);
	public List<User>getAll();
	public User getByName(String name);
	public  User save(User user);
	public  User deleteUser(User user);	
	
}
