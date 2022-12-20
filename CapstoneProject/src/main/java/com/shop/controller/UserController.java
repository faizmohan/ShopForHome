package com.shop.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Roles;
import com.shop.entity.User;
import com.shop.entity.UserRole;
import com.shop.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//	creating user
	//	/user/

	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	//	data will come in json format so @RequestBody
	{
		
//		encoding password with bcryptpassword encoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		
		
		Set<UserRole> roles = new HashSet<>();

		//		class Roles
		Roles role = new Roles();
		role.setRoleId(2L);
		role.setRoleName("NORMAL");

		//		class UserRole
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}

	//	getting user by username
	//	path variable
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok(this.userService.getUsers());
	}

	//	delete the user by id
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable("userid") Long userid) 
	{
		this.userService.delete(userid);
	}

	//	update the user
	@PutMapping("/{userid}")
	public User updateUser(@RequestBody User user, @PathVariable("userid") Long userid) 
	{
		return this.userService.updateUser(user, userid);
	}
}
