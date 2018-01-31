package com.rest.application.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.application.model.User;
import com.rest.application.service.UserService;

@RestController
@RequestMapping("/apis")
public class UserResource implements AppConstants{
	/*
	 * Written by Conroy White  30/01/2018
	 */	
@Autowired
UserService userService;
	/*
	 * retrieve all users from the database
	 */
	@RequestMapping(value=RETRIEVE_REST_DATA,method=RequestMethod.GET)	
	@Produces({MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})	
	public ResponseEntity<List<User>> findAll(){
		List<User>UserList= userService.getAll();
	
		return new ResponseEntity<List<User>>(UserList,HttpStatus.OK);
	}
	/*
	 * create new user into the database
	 */
	@RequestMapping(value=INSERT_VALUES,method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user){
		userService.save(user);
		
		if(userService.equals(null)) {
			return new ResponseEntity<User>(user,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
	}
	/*
	 * get user by name from the database
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value=FIND_BY_NAME,method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getByName(@PathVariable("name") String name){
		
		User user=userService.getByName(name);
		
		if(!user.getName().equalsIgnoreCase(name)) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(user,HttpStatus.OK);
	}
	/*
	 * get user by ID from the database
	 */
	@RequestMapping(value=FING_BY_ID,method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> findUserById(@PathVariable("id") int id){
		
		User user=userService.getById(id);
		
		if(user.getId()!=id) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(user,HttpStatus.OK);
	}
	/*
	 * update selected user from the database
	 */
	@RequestMapping(value=UPDATE_USER,method=RequestMethod.PUT)
	@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user){
		userService.updateUser(user);
		
		if(userService.equals(null)) {
			return new ResponseEntity<User>(user,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
	}
	
	/* 
	 * delete selected user from the database
	 */
	@RequestMapping(value=DELETE_USER,method=RequestMethod.DELETE)
	@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> deleteUser(@RequestBody User user){
		User userByname=userService.save(user);
		userService.deleteUser(userByname);
		
			return new ResponseEntity<User>(user,HttpStatus.NO_CONTENT);
		
	}

}
