package za.co.nico.poc.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.nico.poc.business.logic.processors.BusinessLogicProcessor;
import za.co.nico.poc.dtos.GetProjectsIssueRequest;
import za.co.nico.poc.dtos.GetProjectsRequest;
import za.co.nico.poc.dtos.GetProjectsResponse;

@RestController
public class ReportingController {
	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/projects")
	public GetProjectsResponse getProjectsList() {
		return processor.getProjectsList();
	}

	@PostMapping(value = "/issues", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public GetProjectsResponse getProjectIssuesList(@RequestBody GetProjectsIssueRequest request) {
		return processor.getProjectIssuesList(request);
	}

}
