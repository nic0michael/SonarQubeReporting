package za.co.nico.poc.dtos.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.nico.poc.dtos.ComponentDto;

@Entity
@Table(name = "projects")
public class ProjectEntity {
	private static final Logger log = LoggerFactory.getLogger(ProjectEntity.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "organization")
	private String organization;

	@Column(name = "dto_id")
	private String id;

	@Column(name = "project_key")
	private String key;

	@Column(name = "name")
	private String name;

	@Column(name = "is_favorite")
	private Boolean isFavorite;

	@Column(name = "visibility")
	private String visibility;

	public ProjectEntity() {
	}

	public ProjectEntity(ComponentDto componentDto) {
		if (componentDto != null) {

			this.id = componentDto.getId();			
			this.dateCreated = new Timestamp(System.currentTimeMillis());
			this.organization = componentDto.getOrganization();
			this.key = componentDto.getKey();
			this.name = componentDto.getName();
			this.isFavorite = componentDto.isFavorite();
			this.visibility = componentDto.getVisibility();

		} else {
			log.error("ComponentDto in null");
		}
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		if (projectEntity != null) {
			this.id = projectEntity.getId();
			if(projectEntity.getDateCreated()!=null) {
				this.dateCreated = projectEntity.getDateCreated();
			} else {
				this.dateCreated = new Timestamp(System.currentTimeMillis());
			}
			this.organization = projectEntity.getOrganization();
			this.key = projectEntity.getKey();
			this.name = projectEntity.getName();
			this.isFavorite = projectEntity.getIsFavorite();
			this.visibility = projectEntity.getVisibility();

		} else {
			log.error("ComponentDto in null");
		}
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

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

	public Boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "ProjectEntity [projectId=" + projectId + ", dateCreated=" + dateCreated + ", organization="
				+ organization + ", id=" + id + ", key=" + key + ", name=" + name + ", isFavorite=" + isFavorite
				+ ", visibility=" + visibility + "]";
	}

}
