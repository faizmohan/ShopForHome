package com.shop.service;

import java.util.Set;
import com.shop.entity.User;
import com.shop.entity.UserRole;

public interface UserService {

	//	creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	//	getting user
	public User getUser(String username);
	
//	delete user by id
	public void delete(Long userId);
	
//	update user
	public User updateUser(User user, Long userid);
	
	public Set<User> getUsers();
}
