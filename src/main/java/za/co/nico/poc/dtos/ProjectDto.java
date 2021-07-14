package za.co.nico.poc.dtos;

import java.util.List;

public class ProjectDto {
	List<ComponentDto> componentDtos;

	public List<ComponentDto> getComponentDtos() {
		return componentDtos;
	}

	public void setComponentDtos(List<ComponentDto> componentDtos) {
		this.componentDtos = componentDtos;
	}

	@Override
	public String toString() {
		StringBuilder componentDtostr=new StringBuilder();
		componentDtostr.append("componentDto [");
		for (ComponentDto componentDto : componentDtos) {
			componentDtostr.append("{"+componentDto.key + " " + componentDto.name+"}");
		}
		componentDtostr.append("]");
		return "ProjectDto [componentDtos=" + componentDtostr.toString() + "]";
	}
	

}
