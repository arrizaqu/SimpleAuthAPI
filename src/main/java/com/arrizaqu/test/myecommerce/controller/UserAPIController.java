package com.arrizaqu.test.myecommerce.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arrizaqu.test.myecommerce.dto.UserDto;
import com.arrizaqu.test.myecommerce.entity.Users;
import com.arrizaqu.test.myecommerce.services.UserService;

@RestController
@RequestMapping("/user")
public class UserAPIController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void register(@RequestBody UserDto userDto) throws ParseException {
		Users user = new Users();
		BeanUtils.copyProperties(userDto, user);
		Date format = new SimpleDateFormat("MM/dd/yyyy").parse(userDto.getDateOfBirth());
		user.setDateOfBirth(format);
		userService.saveUserMember(user);
	}

	@GetMapping("/profile")
	public Users profile(Principal principal) {
		Users users = this.userService.getUserByEmail(principal.getName());
		users.setPassword(null);
		return users;
	}
	
	@PostMapping("/updateprofile")
	@ResponseStatus(HttpStatus.OK)
	public void updateProfile(@RequestBody UserDto userDto) throws ParseException {
		Users user = new Users();
		BeanUtils.copyProperties(userDto, user);
		Date format = new SimpleDateFormat("MM/dd/yyyy").parse(userDto.getDateOfBirth());
		user.setDateOfBirth(format);
		userService.update(user);
	}
}
