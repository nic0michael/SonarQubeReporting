package za.co.nico.poc.business.logic.processors;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.nico.poc.dtos.GetProjectsIssueRequest;
import za.co.nico.poc.dtos.GetProjectsRequest;
import za.co.nico.poc.dtos.GetProjectsResponse;
import za.co.nico.poc.services.SonarService;

@Component
public class BusinessLogicProcessor {
	
	@Autowired
	SonarService service;

	public BusinessLogicProcessor() {}
	
	public BusinessLogicProcessor(SonarService service) {
		super();
		this.service = service;
	}

	public GetProjectsResponse getProjectsList() {		
		String rawJson=null;
		String restUrl="http://localhost:9001/api/components/search_projects";
		String platformUrl="http://localhost:9001/";
		String sonarEndPoint="api/components/search_projects";
		
		try {
//			rawJson=service.connectToRest(restUrl);
			rawJson=service.getData( platformUrl, sonarEndPoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public GetProjectsResponse getProjectIssuesList(GetProjectsIssueRequest request) {
		return null;
	}

}
