package com.arrizaqu.test.myecommerce.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arrizaqu.test.myecommerce.entity.Roles;
import com.arrizaqu.test.myecommerce.entity.Users;
import com.arrizaqu.test.myecommerce.repository.RolesRepo;
import com.arrizaqu.test.myecommerce.repository.UsersRepo;

@Service
@Transactional
public class InitDb {
	
	@Autowired
	private UsersRepo userRepo;
	@Autowired
	private RolesRepo rolesRepo;

	@PostConstruct
	public void accountSetup() {
		
		Roles roleAdmin = new Roles();
		roleAdmin.setName("ADMIN");
		rolesRepo.save(roleAdmin);
		
		Roles roleMember = new Roles();
		roleMember.setName("MEMBER");
		rolesRepo.save(roleMember);
		
		Users users = new Users();
		users.setEmail("arrizaqu@yahoo.com");
		users.setMobileNumber("085291222278");
		users.setPassword("1234");
		
		//list role
		List<Roles> roles = new ArrayList();
		roles.add(roleAdmin);
		roles.add(roleMember);
		
		//users have roles
		users.setRoles(roles);
		
		//save to db
		userRepo.save(users);
	}
}
