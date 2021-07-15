package za.co.nico.poc.utils;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import za.co.nico.poc.dtos.ComponentDto;
import za.co.nico.poc.dtos.IssueDto;
import za.co.nico.poc.dtos.ProjectDto;
import za.co.nico.poc.dtos.ProjectIssueDto;
import za.co.nico.poc.dtos.json.Issue;
import za.co.nico.poc.dtos.json.ProjectIssueJsonData;
import za.co.nico.poc.dtos.json.ProjectJsonData;
import za.co.nico.poc.dtos.json.RComponent;

/**
 * https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
 */
public class JsonUtils {
	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

	public static ProjectJsonData getProjectJsonData(String fileText) {
		byte[] jsonData = fileText.getBytes();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProjectJsonData projeJsonData = null;

		try {
			projeJsonData = objectMapper.readValue(jsonData, ProjectJsonData.class);
			log.info("Parsed Projects JSON File");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projeJsonData;

	}

	public static ProjectIssueJsonData getProjectIssueJsonData(String fileText) {
		byte[] jsonData = fileText.getBytes();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProjectIssueJsonData projeJsonData = null;

		try {
			projeJsonData = objectMapper.readValue(jsonData, ProjectIssueJsonData.class);
			log.info("Parsed Issues JSON File");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projeJsonData;

	}

	public static List<IssueDto> getIssues(List<Issue> issues) {
		List<IssueDto> issueDtos = new ArrayList<>();
		for (Issue issue : issues) {
			IssueDto issueDto = convertToIssueDto(issue);
			if (issueDto != null) {
				issueDtos.add(issueDto);
			}
		}
		log.info("Converted "+issueDtos.size()+" IssueDtos");
		return issueDtos;
	}

	private static IssueDto convertToIssueDto(Issue issue) {
		IssueDto issueDto = null;

		if (issue != null) {
			issueDto =new IssueDto();

			issueDto.setKey(issue.getKey());
			issueDto.setRule(issue.getRule());
			issueDto.setSeverity(issue.getSeverity());
			issueDto.setComponent(issue.getComponent());
			issueDto.setProject(issue.getProject());
			issueDto.setLine(issue.getLine());
			issueDto.setHash(issue.getHash());

			if (issue.getTextRange() != null) {
				issueDto.setStartLine(issue.getTextRange().getStartLine());
				issueDto.setEndLine(issue.getTextRange().getEndLine());
				issueDto.setStartOffset(issue.getTextRange().getStartOffset());
				issueDto.setEndOffset(issue.getTextRange().getEndOffset());
			}

			issueDto.setStatus(issue.getStatus());
			issueDto.setMessage(issue.getMessage());
			issueDto.setEffort(issue.getEffort());
			issueDto.setDebt(issue.getDebt());
			issueDto.setAuthor(issue.getAuthor());
			issueDto.setCreationDate(issue.getCreationDate());
			issueDto.setUpdateDate(issue.getUpdateDate());
			issueDto.setType(issue.getType());
			issueDto.setOrganization(issue.getOrganization());
		}

		return issueDto;
	}

	public static List<ComponentDto> getComponentDtos(List<RComponent> components) {
		List<ComponentDto> dtos = new ArrayList<>();
		if (components != null && !components.isEmpty()) {
			int count=0;
			for (RComponent component : components) {
				ComponentDto dto = convertToComponentDto(component);
				if (dto != null) {
					dtos.add(dto);
				}
				count++;
			}
		}
		log.info("Converted "+dtos.size()+" ComponentDtos");
		return dtos;
	}

	public static ComponentDto convertToComponentDto(RComponent component) {
		ComponentDto dto = null;
		if (component != null) {
			dto = new ComponentDto();
			dto.setId(component.getId());
			dto.setKey(component.getKey());
			dto.setName(component.getName());
			dto.setOrganization(component.getOrganization());
			dto.setVisibility(component.getVisibility());
			dto.setFavorite(component.isFavorite());
		}
		return dto;
	}

	public static ProjectDto convertToProjectDto(ProjectJsonData projectJsonData) {
		ProjectDto projectDto = new ProjectDto();
		List<ComponentDto> dtos = getComponentDtos(projectJsonData.getComponents());
		
		if(dtos!=null) {
			projectDto.setComponentDtos(dtos);
			log.info("Converted ProjectDto with "+dtos.size()+" components");
		}
		return projectDto;
	}

	public static ProjectIssueDto convertToProjectIssueDto(ProjectIssueJsonData projectIssueJsonData) {
		ProjectIssueDto projectIssueDto = new ProjectIssueDto();
		List<IssueDto> issues = getIssues(projectIssueJsonData.getIssues());
		if(issues!=null) {
			log.info("Converted ProjectIssueDto with "+issues.size()+" issues");
			projectIssueDto.setIssues(issues);
		}
		return projectIssueDto;
	}

}
