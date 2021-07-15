package za.co.nico.poc.dtos;

import java.util.List;

public class ComponentDto {
    String organization;
    String id;
    String  key;
    String name;
    boolean isFavorite;
    String visibility;
    
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	@Override
	public String toString() {
		return "ComponentDto [organization=" + organization + ", id=" + id + ", key=" + key + ", name=" + name
				+ ", isFavorite=" + isFavorite + ", visibility=" + visibility + "]";
	}
    
}
