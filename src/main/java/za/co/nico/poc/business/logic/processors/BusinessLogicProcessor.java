package za.co.nico.poc.business.logic.processors;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jdk.internal.org.jline.utils.Log;
import za.co.nico.poc.dtos.GetProjectsIssueRequest;
import za.co.nico.poc.dtos.GetProjectsRequest;
import za.co.nico.poc.dtos.GetProjectsResponse;
import za.co.nico.poc.dtos.ProjectDto;
import za.co.nico.poc.dtos.json.ProjectIssueJsonData;
import za.co.nico.poc.dtos.json.ProjectJsonData;
import za.co.nico.poc.services.SonarService;
import za.co.nico.poc.utils.JsonUtils;

@Component
public class BusinessLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(BusinessLogicProcessor.class);
	private static String SUCCESS="SUCCESS";
	private static String FAILED="FAILED";
	private final static String PERSIST_PROJECT_DATA="PERSIST_PROJECT_DATA";
	private final static String PERSIST_PROJECT_ISSUE_DATA="PERSIST_PROJECT_ISSUE_DATA";
	
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

	public String persistProjectData(String fileText) {
		ProjectJsonData projectJsonData =JsonUtils.getProjectJsonData(fileText);
		if(projectJsonData!=null) {
			ProjectDto projectDto = JsonUtils.convertToProjectDto(projectJsonData); 
			log.info("projectDto: "+projectDto.toString());
//			persistProjectData(projectDto);
			return SUCCESS;		
		} else {
			return FAILED;
		}
	}

	public String persistProjectIssueData(String fileText) {
		ProjectIssueJsonData projectIssueJsonData=JsonUtils.getProjectIssueJsonData(fileText);
		if(projectIssueJsonData!=null) {
			return SUCCESS;
		} else {
			return FAILED;
		}
	}
	

    public String processUploadData(String fileText,String action) {

        log.info("fileText : "+fileText);
        
    	if(PERSIST_PROJECT_DATA.equalsIgnoreCase(action)){
    		return persistProjectData(fileText);
    	}else if(PERSIST_PROJECT_ISSUE_DATA.equalsIgnoreCase(action)){
    		return persistProjectIssueData(fileText);
    	} else {
    		return "invalid action : "+action;
    	}
    	
    }
    


}
