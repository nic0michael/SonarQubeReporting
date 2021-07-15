package za.co.nico.poc.dtos;

import java.sql.Date;
import java.util.List;

import za.co.nico.poc.dtos.json.TextRange;

public class IssueDto {
    String key;
    String rule;
    String severity;
    String component;
    String project;
    int line;
    String hash;

	int startLine;
	int endLine;
	int startOffset;
	int endOffset;
	
    String  status;
    String message;
    String effort;
    String debt;
    String author;
    Date  creationDate;
    Date updateDate;
    String type;
    String organization;
    
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
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getEndLine() {
		return endLine;
	}
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}
	public int getStartOffset() {
		return startOffset;
	}
	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}
	public int getEndOffset() {
		return endOffset;
	}
	public void setEndOffset(int endOffset) {
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
		return "IssueDto [key=" + key + ", rule=" + rule + ", severity=" + severity + ", component=" + component
				+ ", project=" + project + ", line=" + line + ", hash=" + hash + ", startLine=" + startLine
				+ ", endLine=" + endLine + ", startOffset=" + startOffset + ", endOffset=" + endOffset + ", status="
				+ status + ", message=" + message + ", effort=" + effort + ", debt=" + debt + ", author=" + author
				+ ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", type=" + type + ", organization="
				+ organization + "]";
	}
    
    

}
