package com.shop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.shop.entity.Roles;
import com.shop.entity.User;
import com.shop.entity.UserRole;
import com.shop.service.UserService;

@SpringBootApplication
public class CapstoneProjectApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {		

		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("start");
		//
		//		Java class "User" object creation 
//		User user = new User();
//
//		//		setting data
//		user.setUsername("faiz");
//		user.setEmail("fazmohan234@gmail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setEnabled(true);
//
//		//		Java class "Roles" object creation
//		Roles roles = new Roles();
//
//		//		setting data
//		roles.setRoleId(1L);
//		roles.setRoleName("ADMIN");
//
//		Set<UserRole> userRolesSet = new HashSet<>();
//
//		//		Java class "UserRole" object creation
//		UserRole userRole = new UserRole();
//
//		//		setting data
//		userRole.setRole(roles);
//		userRole.setUser(user);
//
//		userRolesSet.add(userRole);
//		User user1 = this.userService.createUser(user, userRolesSet);
//		System.out.println(user1.getUsername());

	}

}
