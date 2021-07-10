package za.co.nico.poc.dtos;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetProjectsResponse")
public class GetProjectsResponse {
	String responseStatusCode;
	String responseStatusMessage;
	String databaseResponseStatusCode;
	String databaseResponseStatusMessage;
	String message;
	
	public GetProjectsResponse() {}
	
	public GetProjectsResponse(String responseStatusCode, String responseStatusMessage,
			String databaseResponseStatusCode, String databaseResponseStatusMessage, String message) {
		super();
		this.responseStatusCode = responseStatusCode;
		this.responseStatusMessage = responseStatusMessage;
		this.databaseResponseStatusCode = databaseResponseStatusCode;
		this.databaseResponseStatusMessage = databaseResponseStatusMessage;
		this.message = message;
	}

	public String getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public String getResponseStatusMessage() {
		return responseStatusMessage;
	}

	public void setResponseStatusMessage(String responseStatusMessage) {
		this.responseStatusMessage = responseStatusMessage;
	}

	public String getDatabaseResponseStatusCode() {
		return databaseResponseStatusCode;
	}

	public void setDatabaseResponseStatusCode(String databaseResponseStatusCode) {
		this.databaseResponseStatusCode = databaseResponseStatusCode;
	}

	public String getDatabaseResponseStatusMessage() {
		return databaseResponseStatusMessage;
	}

	public void setDatabaseResponseStatusMessage(String databaseResponseStatusMessage) {
		this.databaseResponseStatusMessage = databaseResponseStatusMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GetProjectsResponse [responseStatusCode=" + responseStatusCode + ", responseStatusMessage="
				+ responseStatusMessage + ", databaseResponseStatusCode=" + databaseResponseStatusCode
				+ ", databaseResponseStatusMessage=" + databaseResponseStatusMessage + ", message=" + message + "]";
	}

}
