package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.BidEntity;
import com.marketplace.entity.ProjectEntity;
import com.marketplace.repo.BidRepo;
import com.marketplace.repo.ProjectRepo;

@Service
public class JobService {

	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	BidRepo bidRepo;
	
	public void selectBid() {
		// Get the project expired in last 24 hours.
		List<ProjectEntity> projList = projectRepo.getProjectByLastDate();
		System.out.println(" projList --> "+projList);
		// select the lowest bid
		projList.forEach((p)-> {
			System.out.println(" p.getId() --> "+p.getId());
			BidEntity bid = bidRepo.findLowestBidByProjectId(p.getId());
			System.out.println("bid "+bid);
			if(bid!=null) {
				// update project with assignee and status
				p.setAssignedUser(String.valueOf(bid.getUserId()));
				p.setStatus("CLOSED");
			} else {
				p.setStatus("CLOSED");
			}
			projectRepo.save(p);
		});	
	}
}
