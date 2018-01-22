package com.marketplace.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.marketplace.entity.ProjectEntity;

public interface ProjectRepo extends CrudRepository<ProjectEntity, Long> {

	public List<ProjectEntity> findProjectByStatus(String status);
	
	public ProjectEntity findProjectByCode(String code); 
	
	public ProjectEntity getProjectByCodeAndStatus(String code,String status);
	
	@Query(value="select * from project where last_date>sysdate-24 and last_date<sysdate",nativeQuery=true)
	public List<ProjectEntity> getProjectByLastDate();
}
