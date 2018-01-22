package com.marketplace.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.service.BidService;
import com.marketplace.service.JobService;
import com.marketplace.vo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Job to assign project the user", description = "Job to assign project the user")
@RequestMapping(path = "/job")
public class JobController {
	private static final Logger logger = LoggerFactory.getLogger(JobController.class);

	@Autowired
	JobService service;

	
	@ApiOperation(value = "Confirm the bid")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
           })
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "X-USER-ID", dataType = "String", paramType = "header", required = true, value = "User Id"),
            @ApiImplicitParam(name = "X-SOURCE", dataType = "String", paramType = "header", required = true, value = "Source"),
    })*/
    @RequestMapping(value = "/confirm", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> confirm()

    {
        logger.info("Request : confirm the bid ");
        service.selectBid();
        return ResponseEntity.ok(null);
    }
}
