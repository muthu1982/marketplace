package com.marketplace.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.service.UserService;
import com.marketplace.vo.Project;
import com.marketplace.vo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "To register a user", description = "To register a user")
@RequestMapping(path = "/user")
public class UserController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService service;
	
	@ApiOperation(value = "Get user list")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
           })
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "X-USER-ID", dataType = "String", paramType = "header", required = true, value = "User Id"),
            @ApiImplicitParam(name = "X-SOURCE", dataType = "String", paramType = "header", required = true, value = "Source"),
    })*/
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllUser()

    {
        logger.info("Request : Retrieving all the active projects ");
        List<User>userLst = service.getAllUsers();
        return new ResponseEntity(userLst, HttpStatus.OK);
    }
	
	@ApiOperation(value = "create a user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
           })
    @PostMapping(produces = "application/json")
	public ResponseEntity create(@RequestBody(required = true) User user)  {
		service.save(user);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
