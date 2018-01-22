package com.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.BidEntity;
import com.marketplace.entity.ProjectEntity;
import com.marketplace.repo.BidRepo;
import com.marketplace.repo.ProjectRepo;
import com.marketplace.vo.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	BidRepo bidRepo;
	
	/**
	 * @param project
	 */
	public void create(Project project) {
		ProjectEntity entity = new ProjectEntity();
		entity.setName(project.getName());
		entity.setBudget(project.getMaxBudget());
		entity.setDescription(project.getDescription());
		entity.setLastDate(project.getLastDate());
		entity.setCode(project.getCode());
		entity.setStatus("OPEN");
		projectRepo.save(entity);
	}
	
	 
    /**
     * @return
     */
    public List<Project> findAllProject(String status) {
		Iterable<ProjectEntity>  projectEntityLst = projectRepo.findProjectByStatus(status);
		List<Project> projectLst = new ArrayList<>();
		projectEntityLst.forEach((e) -> {
			Project project = new Project();
			project.setMaxBudget(e.getBudget());
			project.setName(e.getName());
			project.setDescription(e.getDescription());
			project.setCode(e.getCode());
			project.setLastDate(e.getLastDate());
			BidEntity bid = bidRepo.findLowestBidByProjectId(e.getId());
			if(bid!=null) {
				project.setLowestBid(bid.getBidAmount());
			}
			projectLst.add(project);
			
		});
		return projectLst;
	}
    
    /**
     * 
     * @param code
     * @return
     */
    public ProjectEntity findProjectByCode(String code) {
    	return projectRepo.getProjectByCodeAndStatus(code,"OPEN");
    }
    
    
    /**
     * 
     * @param code
     * @return
     */
    public Project findProjectById(String code) {
    	ProjectEntity entity = projectRepo.findProjectByCode(code);
    	Project project = new Project();
		project.setMaxBudget(entity.getBudget());
		project.setName(entity.getName());
		project.setDescription(entity.getDescription());
		project.setCode(entity.getCode());
		project.setLastDate(entity.getLastDate());
		BidEntity bid = bidRepo.findLowestBidByProjectId(entity.getId());
		project.setLowestBid(bid.getBidAmount());
		return project;
    }
       
}
