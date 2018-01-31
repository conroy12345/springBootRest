package com.rest.application.service;

import java.util.List;

import com.rest.application.model.User;




public interface UserService {
	
	public User getById(int id);
	public List<User>getAll();
	public User getByName(String name);
	public User save(User user);
	public  User deleteUser(User user);
	public  User updateUser(User user);
	public List<User> findAllUsersList();

}
