package com.arrizaqu.test.myecommerce.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrizaqu.test.myecommerce.entity.Roles;
import com.arrizaqu.test.myecommerce.entity.Users;
import com.arrizaqu.test.myecommerce.repository.RolesRepo;
import com.arrizaqu.test.myecommerce.repository.UsersRepo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UsersRepo userRepo;
	
	@Autowired
	private RolesRepo roleRepo;

	public void saveUserMember(Users user) {
		List<Roles> roles = roleRepo.findByName("MEMBER");
		user.setRoles(roles);
		userRepo.save(user);
	}
	
	public Users getUserByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
	
	public void update(Users user) {
		// TODO Auto-generated method stub
		this.userRepo.updateUserInfo(user.getId(), user.getFirstName(),user.getLastName(),user.getGender(),user.getDateOfBirth());
	}
}
