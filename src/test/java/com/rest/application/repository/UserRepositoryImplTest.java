package com.rest.application.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.rest.application.jdbc.connection.QueryParam;
import com.rest.application.model.User;

public class UserRepositoryImplTest {

	QueryParam datasource= new QueryParam();
	User user= new User();
	
	@Autowired
	UserRepository repos;
	
	@Test
	public void testGetById() {
		//List<User>users=QueryParam .fingAll();
		user=QueryParam .getById(new User(), 1);				
		assertEquals(user.getName(),"conroy");
		
	}

	@Test
	public void testGetAll() {
		List<User>users=QueryParam .fingAll();
		assertNotNull(users);
	}

	@Test
	public void testGetByName() {
		user=QueryParam .getByName(new User(), "delroy");
		assertEquals(user.getName(),"delroy");
		
	}

	@Test
	public void testSave() {
		
		user.setName("test user");		
		user.setAddress("test address");
		user=QueryParam .getByName(new User(), "test user");
		QueryParam.saveUser(user);
		assertEquals(user.getName(),"test user");
	}

	

}
