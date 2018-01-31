package com.rest.application.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.application.model.User;


@Repository("employeeDao")
public class UserRepositoryImpl extends AbstractRepository<Integer, User> implements
		UserRepository {

	@Autowired
	EntityManager ent;
	
	@Override
	public User getById(int id) {
		
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		
		return createEntityCriteria().list();
	}

	@Override
	public User getByName(String name) {
		Criteria criteria = createEntityCriteria();
		createEntityCriteria().add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("name", name));
        return (User) criteria.uniqueResult();
	}

	
	@Override
	public  User save(User user) {
		persist(user);
		return user;		

	}

	@Override
	public  User deleteUser(User user) {
		getSession().delete(user);
		Transaction tran=getSession().beginTransaction();
		tran.commit();
		return user;
		
	}

}
