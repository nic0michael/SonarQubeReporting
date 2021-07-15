package za.co.nico.poc.business.logic.processors;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jdk.internal.org.jline.utils.Log;
import za.co.nico.poc.dtos.ComponentDto;
import za.co.nico.poc.dtos.GetProjectsIssueRequest;
import za.co.nico.poc.dtos.GetProjectsRequest;
import za.co.nico.poc.dtos.GetProjectsResponse;
import za.co.nico.poc.dtos.IssueDto;
import za.co.nico.poc.dtos.ProjectDto;
import za.co.nico.poc.dtos.ProjectIssueDto;
import za.co.nico.poc.dtos.json.ProjectIssueJsonData;
import za.co.nico.poc.dtos.json.ProjectJsonData;
import za.co.nico.poc.dtos.model.ProjectEntity;
import za.co.nico.poc.dtos.model.ProjectIssueEntity;
import za.co.nico.poc.repositories.ProjectIssueRepository;
import za.co.nico.poc.repositories.ProjectRepository;
import za.co.nico.poc.services.SonarService;
import za.co.nico.poc.utils.JsonUtils;

@Component
public class BusinessLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(BusinessLogicProcessor.class);
	private static String SUCCESS = "SUCCESS";
	private static String FAILED = "FAILED";
	private final static String PERSIST_PROJECT_DATA = "PERSIST_PROJECT_DATA";
	private final static String PERSIST_PROJECT_ISSUE_DATA = "PERSIST_PROJECT_ISSUE_DATA";

	@Autowired
	SonarService service;

	@Autowired
	ProjectIssueRepository projectIssueRepository;

	@Autowired
	ProjectRepository projectRepository;

	public BusinessLogicProcessor() {
	}

	public BusinessLogicProcessor(SonarService service) {
		super();
		this.service = service;
	}

	public GetProjectsResponse getProjectsList() {
		String rawJson = null;
		String restUrl = "http://localhost:9001/api/components/search_projects";
		String platformUrl = "http://localhost:9001/";
		String sonarEndPoint = "api/components/search_projects";

		try {
//			rawJson=service.connectToRest(restUrl);
			rawJson = service.getData(platformUrl, sonarEndPoint);
			log.debug("rawJson : " + rawJson.length() + " Bytes");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public GetProjectsResponse getProjectIssuesList(GetProjectsIssueRequest request) {
		return null;
	}

	public String persistProjectData(String fileText) {
		ProjectJsonData projectJsonData = JsonUtils.getProjectJsonData(fileText);
		if (projectJsonData != null) {
			ProjectDto projectDto = JsonUtils.convertToProjectDto(projectJsonData);
			persistProjectData(projectDto);
			log.info("Suceeded to get projectJsonData persisted");
			return SUCCESS;
		} else {
			return FAILED;
		}
	}

	public String persistProjectIssueData(String fileText) {
		ProjectIssueJsonData projectIssueJsonData = JsonUtils.getProjectIssueJsonData(fileText);
		if (projectIssueJsonData != null) {
			ProjectIssueDto projectIssueDto = JsonUtils.convertToProjectIssueDto(projectIssueJsonData);
			persistProjectIssueData(projectIssueDto);
			log.info("Suceeded to get projectIssueJsonData persisted");
			return SUCCESS;
		} else {
			return FAILED;
		}
	}

	public String processUploadData(String fileText, String action) {

		if (PERSIST_PROJECT_DATA.equalsIgnoreCase(action)) {
			return persistProjectData(fileText);
		} else if (PERSIST_PROJECT_ISSUE_DATA.equalsIgnoreCase(action)) {
			return persistProjectIssueData(fileText);
		} else {
			return "invalid action : " + action;
		}

	}

	private void persistProjectData(ProjectDto projectDto) {
		ProjectEntity projectEntity = null;
		if (projectDto != null) {
			List<ComponentDto> componentDtos = projectDto.getComponentDtos();
			if (componentDtos != null) {
				log.info("ProjectDto has " + componentDtos.size() + " ComponentDtos");

				int count = 0;
				for (ComponentDto componentDto : componentDtos) {
					projectEntity = new ProjectEntity(componentDto);
					if (count < 5) {
						log.info("persisting ProjectEntity " + projectEntity.toString());
					}
					persist(projectEntity,count);
					count++;
				}

				if (projectEntity == null) {
					log.info("persist ProjectDto");

				}

			}
		}

	}

	private void persistProjectIssueData(ProjectIssueDto projectIssueDto) {
		ProjectIssueEntity projectIssueEntity = null;
		if (projectIssueDto != null) {
			List<IssueDto> issues = projectIssueDto.getIssues();

			if (issues != null) {
				log.info("persisting " + issues.size() + " projectIssueEntities ");
				int count = 0;
				for (IssueDto issueDto : issues) {
					projectIssueEntity = new ProjectIssueEntity(issueDto);
					persist(projectIssueEntity, count);
					count++;
				}
				log.info("persisted " + issues.size() + " projectIssueEntities ");
			}
		}

	}

	/**
	 * select * from project_issue order by issue_key;
	 */
	private void persist(ProjectIssueEntity projectIssueEntity, int count) {
		ProjectIssueEntity foundProjectIssueEntity =null;
		String key = projectIssueEntity.getKey();
		if (count < 5) {
			log.info("persisting projectIssueEntity " + key + " " + projectIssueEntity.getComponent());
		}
		foundProjectIssueEntity = projectIssueRepository.findByKey(key);
		if (foundProjectIssueEntity != null) {
			if (count < 5) {
				log.info("found " + foundProjectIssueEntity.getKey());
			}
			projectIssueRepository.save(foundProjectIssueEntity);
		} else {
			projectIssueRepository.save(projectIssueEntity);
		}

	}

	/**
	 * select * from projects order by dto_id;
	 */
	private void persist(ProjectEntity projectEntity, int count) {
		ProjectEntity foundProjectEntity=null;
		String dtoId = projectEntity.getId();
		if (count < 5) {
			log.info("persisting projectIssueEntity " + dtoId + " " + projectEntity.getName() + " "
					+ projectEntity.getId());
		}
		foundProjectEntity= projectRepository.findById(dtoId);
		if (foundProjectEntity != null) {
			if (count < 5) {
				log.info("found " + foundProjectEntity.getId());
			}
			projectRepository.save(foundProjectEntity);
		} else {
			projectRepository.save(projectEntity);
		}
	}

}
