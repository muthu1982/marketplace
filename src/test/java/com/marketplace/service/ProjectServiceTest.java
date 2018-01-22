package com.marketplace.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.marketplace.entity.BidEntity;
import com.marketplace.entity.ProjectEntity;
import com.marketplace.repo.BidRepo;
import com.marketplace.repo.ProjectRepo;
import com.marketplace.vo.Project;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjectService.class)
public class ProjectServiceTest {

	@Autowired
	ProjectService service;
	
	@MockBean
	ProjectRepo projectRepo;
	
	@MockBean
	BidRepo bidRepo;
	
	
	 @Test
	    public void basics() {
	        assertNotNull(service);
	    }



	    @Test
	    public void testFindProjectById() {
	        ProjectEntity entity = new ProjectEntity();
	        entity.setCode("P1");
	        entity.setDescription("Project 1");
	        entity.setBudget(1000);
	        entity.setLastDate(new Date(System.currentTimeMillis()));
	        List<String> cvpList = new ArrayList<String>();
	        cvpList.add("12882");
	        Mockito.when(projectRepo.findProjectByCode(Mockito.any(String.class))).thenReturn(entity);
	        
	        BidEntity bidEntity = new BidEntity();
	        bidEntity.setBidAmount(2000);
	        Mockito.when(bidRepo.findLowestBidByProjectId(Mockito.any(Integer.class))).thenReturn(bidEntity);
	        Project response = service.findProjectById("OPEN");
	        assertEquals("Project 1", response.getDescription());
	    }
}
