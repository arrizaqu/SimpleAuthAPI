package com.arrizaqu.test.myecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arrizaqu.test.myecommerce.entity.Roles;
import com.arrizaqu.test.myecommerce.entity.Users;
import com.arrizaqu.test.myecommerce.repository.UsersRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//email or mobile number
		Users users = this.usersRepo.findByEmail(email);
		//add Authorities
		List<GrantedAuthority> listAuto = new ArrayList<GrantedAuthority>();

		for(int i = 0; i < users.getRoles().size(); i++) {
			listAuto.add(new SimpleGrantedAuthority("ROLE_" + users.getRoles().get(i).getName().toUpperCase()));
		}
		
		return new User(users.getEmail(), users.getPassword(), listAuto);
	}

}
