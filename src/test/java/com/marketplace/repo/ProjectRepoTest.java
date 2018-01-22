package com.marketplace.repo;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marketplace.entity.ProjectEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class ProjectRepoTest {

	  @Autowired
	  private TestEntityManager entityManager;
	  
	  @Autowired 
	  private ProjectRepo repo;

	    @Test
	    public void testGetDeviceLoopBackInfo(){
	        ProjectEntity entity=new ProjectEntity();
	        entity.setCode("P10");
	        entity.setName("Project 1");
	        entity.setStatus("OPEN");
	        entity.setBudget(1000);
	        entity.setDescription("Project 1");
	        entity.setLastDate(new Date(System.currentTimeMillis()));
	        entityManager.persist(entity);
	        ProjectEntity responseEntity=repo.getProjectByCodeAndStatus("P1", "OPEN");
	        assertNotNull(entity.getName(),responseEntity.getName());
	    }
}
