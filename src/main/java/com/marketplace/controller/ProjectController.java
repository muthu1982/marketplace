package com.marketplace.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.service.BidService;
import com.marketplace.service.ProjectService;
import com.marketplace.vo.Bid;
import com.marketplace.vo.Project;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "To add a project", description = "To add a project")
@RequestMapping(path = "/project")
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService service;
	
	@Autowired
	BidService bidService;
	
	/**
	 * Create  a project.
	 * @param project
	 * @return
	 */
	@PostMapping(produces = "application/json")
	public ResponseEntity create(@RequestBody(required = true) Project project)  {
		service.create(project);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	/**
	 * Create  a bid against a project.
	 * @param project
	 * @return
	 */
	@PostMapping(path="/bid", produces = "application/json")
	public ResponseEntity bid(@RequestBody(required = true) Bid bid)  {
		try {
			bidService.save(bid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "Get project list")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
           })
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "X-USER-ID", dataType = "String", paramType = "header", required = true, value = "User Id"),
            @ApiImplicitParam(name = "X-SOURCE", dataType = "String", paramType = "header", required = true, value = "Source"),
    })*/
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllProject( @RequestParam(value = "status", required = false , defaultValue="OPEN") String status )
    {
        logger.info("Request : Retrieving all the active projects ");
        List<Project> projectLst = service.findAllProject(status);
        return ResponseEntity.ok(projectLst);
    }
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Get project by Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
           })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getProjectById(@PathVariable("id") String code)

    {
        logger.info("Request : Retrieving project by code . code = "+code);
        Project projectLst = service.findProjectById(code);
        return ResponseEntity.ok(projectLst);
    }
	
	
	
}
