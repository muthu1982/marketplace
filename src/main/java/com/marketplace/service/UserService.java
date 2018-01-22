package com.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.ProjectEntity;
import com.marketplace.entity.UserEntity;
import com.marketplace.repo.UserRepo;
import com.marketplace.vo.Project;
import com.marketplace.vo.User;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public void save(User user) {
	   UserEntity entity = new UserEntity();
	   entity.setEmailId(user.getEmailId());
	   entity.setName(user.getName());
	   userRepo.save(entity);  
	}
	
	
	public UserEntity getUserByEmailId(String emailId) {
		return userRepo.getUserByEmailId(emailId);
	}
	
	public List<User> getAllUsers() {
		Iterable<UserEntity>  projectEntityLst = userRepo.findAll();
		List<User> userLst = new ArrayList<>();
		projectEntityLst.forEach((e) -> {
			User user = new User();
			user.setEmailId(e.getEmailId());
			user.setName(e.getName());
			userLst.add(user);
			
		});
		return userLst;
	}
	
}
