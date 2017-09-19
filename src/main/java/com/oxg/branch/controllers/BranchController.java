package com.oxg.branch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxg.branch.documents.Branch;
import com.oxg.branch.repository.BranchRepository;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Scope("singleton")
public class BranchController {

	@Autowired
	private BranchRepository repository;
	
	
	@ApiOperation(value = "getAllLocations", nickname = "getAllLocations")
    @RequestMapping(method = RequestMethod.GET, path="/branches/v1/locations", produces = "application/json")
    @ApiImplicitParams({
    	//need it if the parameter is a query parameter
        //@ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query"
        		//, defaultValue="Niklas")
        		
      })
    
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Branch.class, responseContainer="List"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 

	public List<Branch> getAllLocations () {
		List<Branch> result = repository.findAll();
		return result;
    }
    
	@ApiOperation(value = "getLocation", nickname = "getLocation")
    @RequestMapping(method = RequestMethod.GET, path="/branches/v1/{branchId}/location", produces = "application/json")
    @ApiImplicitParams({
    	//need it if the parameter is a query parameter
        //@ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query"
        		//, defaultValue="Niklas")
        		
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Branch.class, responseContainer="List"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    
    public Branch getLocation (@PathVariable("branchId") int branchId) {
		Branch result = (Branch) repository.findById(branchId); 
		return result;
    }
	
	
}
