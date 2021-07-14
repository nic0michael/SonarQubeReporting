package za.co.nico.poc.utils;

import java.io.IOException;
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
import za.co.nico.poc.dtos.ProjectDto;
import za.co.nico.poc.dtos.json.ProjectIssueJsonData;
import za.co.nico.poc.dtos.json.ProjectJsonData;
import za.co.nico.poc.dtos.json.RComponent;

/**
 * https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
 */
public class JsonUtils {
	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
	
	public static ProjectJsonData getProjectJsonData(String fileText) {
		byte[] jsonData=fileText.getBytes();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProjectJsonData projeJsonData = null;
		
		try {
			projeJsonData = objectMapper.readValue(jsonData, ProjectJsonData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projeJsonData;
		
	}
	
	public static ProjectIssueJsonData getProjectIssueJsonData(String fileText) {
		byte[] jsonData=fileText.getBytes();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProjectIssueJsonData projeJsonData = null;
		
		try {
			projeJsonData = objectMapper.readValue(jsonData, ProjectIssueJsonData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projeJsonData;
		
	}
	
	public static List<ComponentDto> getComponentDtos(List<RComponent>components) {
		List<ComponentDto> dtos =new ArrayList<>();
		if(components !=null && !components.isEmpty()) {
			for (RComponent component : components) {
				ComponentDto dto=convertToComponentDto(component);
				if(dto!=null) {
					dtos.add(dto);
				}
			}
		}
		return dtos;
	}

	public static ComponentDto convertToComponentDto(RComponent component) {
		ComponentDto dto=null;
		if(component!=null) {
			dto=new ComponentDto();
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
		ProjectDto projectDto=new ProjectDto();
		List<ComponentDto> dtos =getComponentDtos(projectJsonData.getComponents());
		projectDto.setComponentDtos(dtos);
		return projectDto;
	}

}
