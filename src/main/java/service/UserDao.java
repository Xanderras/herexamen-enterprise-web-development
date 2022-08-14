package service;

import java.util.List;

import domain.User;

public interface UserDao {

	public List<User> findAll();
	
}
