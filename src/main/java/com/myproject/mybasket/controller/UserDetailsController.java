package com.myproject.mybasket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.mybasket.dao.UserDetailsDao;
import com.myproject.mybasket.user.CorporateScheduleDetailsEntity;
import com.myproject.mybasket.user.ScheduleDetailsEntity;
import com.myproject.mybasket.user.Users;


@Controller
@RequestMapping("/api")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsDao userDetailsDao;

	@PostMapping("/userDetails")
	public @ResponseBody ScheduleDetailsEntity createUser(@Valid @RequestBody ScheduleDetailsEntity user) {
		System.out.println("user data is" + user);
		return userDetailsDao.saveUserDetails(user);
//		return null;
	}
	
	@PostMapping("/corporateUserDetails")
	public @ResponseBody CorporateScheduleDetailsEntity createUser(@Valid @RequestBody CorporateScheduleDetailsEntity user) {
		System.out.println("user data is" + user);
		return userDetailsDao.saveCorporateUserDetails(user);
//		return null;
	}
	
	@PostMapping("/registerUser")
	public @ResponseBody Users registerUser(@Valid @RequestBody Users user) {
		System.out.println("user data is" + user);
		return userDetailsDao.registerNewUser(user);
//		return null;
	}
	
	@GetMapping("/getAllUserDetails")
	public @ResponseBody List<ScheduleDetailsEntity> getAllUserData(){
		
		List<ScheduleDetailsEntity> users= userDetailsDao.findAll();
		return users;
	}
	
	@GetMapping("/getAllCorporateUserDetails")
	public @ResponseBody List<CorporateScheduleDetailsEntity> getAllCorporateUsers(){
		
		List<CorporateScheduleDetailsEntity> users= userDetailsDao.findAllCorporateUsers();
		return users;
	}
	
	@PostMapping("/loginUser")
	public @ResponseBody Users loginUser(@Valid @RequestBody Users user) {
		System.out.println("user data is" + user);
		Users logUser = userDetailsDao.loginUser(user);
		System.out.println("logUser data is" + logUser);
		return logUser;
	}
	
}
