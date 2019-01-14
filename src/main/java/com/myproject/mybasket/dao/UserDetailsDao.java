package com.myproject.mybasket.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.mybasket.repository.CorporateUserDetailsRepository;
import com.myproject.mybasket.repository.NotificationDetailsRepository;
import com.myproject.mybasket.repository.RegisterUserRepository;
import com.myproject.mybasket.repository.UserDetailsRepository;
import com.myproject.mybasket.user.CorporateScheduleDetailsEntity;
import com.myproject.mybasket.user.NotificationDetails;
import com.myproject.mybasket.user.ScheduleDetailsEntity;
import com.myproject.mybasket.user.Users;
import com.myproject.mybasket.utility.SendNotificationMail;


@Service
public class UserDetailsDao {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private NotificationDetailsRepository notificationDetailsRepository;
	
	@Autowired
	private RegisterUserRepository registerUserRepository;
	
	@Autowired
	private CorporateUserDetailsRepository corporateUserDetailsRepository;

	/*to save user details*/
	public ScheduleDetailsEntity saveUserDetails(ScheduleDetailsEntity userDetails) {
		
		ScheduleDetailsEntity user= userDetailsRepository.save(userDetails);
		NotificationDetails td=new NotificationDetails();
		td.setMessage("Scheduling for "+user.getFirstName());
		td.setScheduleDetails(user);
		SendNotificationMail.sendEmail();
		notificationDetailsRepository.save(td);
		return user;
		
	}
	
	/*to save corporate user details*/
	public CorporateScheduleDetailsEntity saveCorporateUserDetails(CorporateScheduleDetailsEntity corporateScheduleDetailsEntity) {
		
		CorporateScheduleDetailsEntity user= corporateUserDetailsRepository.save(corporateScheduleDetailsEntity);
		NotificationDetails td=new NotificationDetails();
		td.setMessage("Scheduling for "+user.getCompanyName());
		SendNotificationMail.sendEmail();
		notificationDetailsRepository.save(td);
		return user;
		
	}
	
	/*to search user details*/
	
	public List<ScheduleDetailsEntity> findAll(){
		//SendNotificationMail.sendEmail();
		List<ScheduleDetailsEntity> users = userDetailsRepository.findAll();
		return users;
	}

	public Users registerNewUser(@Valid Users user) {
		// TODO Auto-generated method stub
		return registerUserRepository.save(user);
	}

	
	public Users loginUser(@Valid Users user) {
		try {
		return registerUserRepository.loginUser(user.getUserName(), user.getPassword()).get();
		}
		catch(Exception e)
		{
			return new Users();
		}
	}

	public List<CorporateScheduleDetailsEntity> findAllCorporateUsers() {
		// TODO Auto-generated method stub
		return corporateUserDetailsRepository.findAll();
	}
	
}
