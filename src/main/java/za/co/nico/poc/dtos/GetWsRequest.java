package za.co.nico.poc.dtos;

import java.util.Map;

import org.sonarqube.ws.client.WsRequest;

public class GetWsRequest implements WsRequest{

	private Method method;
	private String path;
	private String mediaType;

	
	
	public GetWsRequest(Method method, String path, String mediaType) {
		super();
		this.method = method;
		this.path = path;
		this.mediaType = mediaType;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public String getMediaType() {
		return mediaType;
	}

	@Override
	public Map<String, String> getParams() {
		// TODO Auto-generated method stub
		return null;
	}

}
