package com.rest.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.application.model.User;
import com.rest.application.repository.UserRepository;
@Service("employeeService")
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
UserRepository dao;

	@Override
	public User getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public List<User> getAll() {
		
		return dao.getAll();
	}

	@Override
	public User getByName(String name) {
		
		return dao.getByName(name);
	}

	@Override
	public User save(User user) {
		dao.save(user);
		return user;

	}

	@Override
	public  User deleteUser(User user) {
		dao.deleteUser(user);	
		return user;

	}

	@Override
	public  User updateUser(User user) {
		User obj=dao.getById(user.getId());
		if(obj!=null){
			obj.setName(user.getName());			
			obj.setAddress(user.getAddress());
			
		}
		return user;
	}

	@Override
	public boolean isUpdatedUnique(Integer id, String ssn) {
		User employee = getByName(ssn);
	        return ( employee == null || ((id != null) && (employee.getId() == id)));
	}

}
