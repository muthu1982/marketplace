package com.marketplace.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.BidEntity;
import com.marketplace.entity.ProjectEntity;
import com.marketplace.entity.UserEntity;
import com.marketplace.exception.ProjectNotFound;
import com.marketplace.exception.UserNotFound;
import com.marketplace.repo.BidRepo;
import com.marketplace.vo.Bid;

@Service
public class BidService {

	@Autowired
	BidRepo bidRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	
	public void save(Bid bid) throws Exception {
		//get project Object.
		ProjectEntity project = projectService.findProjectByCode(bid.getProjectCode());
		if(project==null) {
			throw new ProjectNotFound("","");
		}
		// get user Object.
		UserEntity user = userService.getUserByEmailId(bid.getEmailId());
		if(user==null) {
			throw new UserNotFound("","");
		}
		//save the bid.
		BidEntity entity = new BidEntity();
		entity.setBidAmount(bid.getBidAmount());
		entity.setProjectId(project.getId());
		entity.setUserId(user.getId());
		entity.setBidDate(new Date(System.currentTimeMillis()));
		bidRepo.save(entity);
	}
	
	
}
