package com.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.entity.UserRole;
import com.shop.repo.RoleRepository;
import com.shop.repo.UserRespository;
import com.shop.service.UserService;
import com.shop.exception.*;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private RoleRepository roleRespository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User local = this.userRespository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User already registered");
			throw new Exception("User already registered");
		}
		else 
		{
//			create user
			for(UserRole ur:userRoles)
			{
				roleRespository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRespository.save(user);
		}
		
		return local;
	}

//	getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRespository.findByUsername(username);
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		this.userRespository.deleteById(userId);
	}

	@Override
	public User updateUser(User user, Long userid) {
		// TODO Auto-generated method stub
		User fetchuser = this.userRespository.findById(userid).orElseThrow(()-> new ResourceNotFoundException("User","Id",userid));
		
		fetchuser.setUsername(user.getUsername());
		fetchuser.setEmail(user.getEmail());
		fetchuser.setPassword(user.getPassword());
		
		User updatedUser = this.userRespository.save(fetchuser);
		return updatedUser;
	}

	@Override
	public Set<User> getUsers() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.userRespository.findAll());
	}
	
	
}
