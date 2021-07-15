package za.co.nico.poc.dtos.model;

import java.io.Serializable;
import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.nico.poc.dtos.IssueDto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * The persistent class for the 'project Issue' database table.
 * 
 */
@Entity
@Table(name = "project_issue")
public class ProjectIssueEntity implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(ProjectIssueEntity.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_issue_id")
	private Long  projectIssueId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "issue_key")
	private String key;

	@Column(name = "rule")
	String rule;

	@Column(name = "severity")
	String severity;

	@Column(name = "component")
	String component;

	@Column(name = "project")
	String project;

	@Column(name = "line_nr")
	Integer line;

	@Column(name = "hash")
	String hash;

	@Column(name = "startLine")
	Integer startLine;

	@Column(name = "endLine")
	Integer endLine;

	@Column(name = "startOffset")
	Integer startOffset;

	@Column(name = "endOffset")
	Integer endOffset;

	@Column(name = "status")
	String status;

	@Column(name = "message")
	String message;

	@Column(name = "effort")
	String effort;

	@Column(name = "debt")
	String debt;

	@Column(name = "author")
	String author;

	@Column(name = "creationDate")
	Date creationDate;

	@Column(name = "updateDate")
	Date updateDate;

	@Column(name = "type")
	String type;

	@Column(name = "organization")
	String organization;
	

	public ProjectIssueEntity() {}
	
	public ProjectIssueEntity(IssueDto issueDto) {

		if (issueDto != null) {

			this.setKey(issueDto.getKey());
			this.setRule(issueDto.getRule());
			this.setSeverity(issueDto.getSeverity());
			this.setComponent(issueDto.getComponent());
			this.setProject(issueDto.getProject());
			this.setLine(issueDto.getLine());
			this.setHash(issueDto.getHash());

			this.setStartLine(issueDto.getStartLine());
			this.setEndLine(issueDto.getEndLine());
			this.setStartOffset(issueDto.getStartOffset());
			this.setEndOffset(issueDto.getEndOffset());

			this.setStatus(issueDto.getStatus());
			this.setMessage(issueDto.getMessage());
			this.setEffort(issueDto.getEffort());
			this.setDebt(issueDto.getDebt());
			this.setAuthor(issueDto.getAuthor());
			this.setCreationDate(issueDto.getCreationDate());
			this.setUpdateDate(issueDto.getUpdateDate());
			this.setType(issueDto.getType());
			this.setOrganization(issueDto.getOrganization());
		} else {
			log.error("Constructing this class with issueDto as a null");
		}
	}


	public Long getProjectIssueId() {
		return projectIssueId;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Integer getStartLine() {
		return startLine;
	}

	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}

	public Integer getEndLine() {
		return endLine;
	}

	public void setEndLine(Integer endLine) {
		this.endLine = endLine;
	}

	public Integer getStartOffset() {
		return startOffset;
	}

	public void setStartOffset(Integer startOffset) {
		this.startOffset = startOffset;
	}

	public Integer getEndOffset() {
		return endOffset;
	}

	public void setEndOffset(Integer endOffset) {
		this.endOffset = endOffset;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getDebt() {
		return debt;
	}

	public void setDebt(String debt) {
		this.debt = debt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "ProjectIssueEntity [projectIssueId=" + projectIssueId + ", dateCreated=" + dateCreated + ", key=" + key
				+ ", rule=" + rule + ", severity=" + severity + ", component=" + component + ", project=" + project
//				+ ", line=" + line + ", hash=" + hash + ", startLine=" + startLine + ", endLine=" + endLine
				+ ", startOffset=" + startOffset + ", endOffset=" + endOffset + ", status=" + status + ", message="
				+ message + ", effort=" + effort + ", debt=" + debt + ", author=" + author + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", type=" + type + ", organization=" + organization
				+ "]";
	}

}
