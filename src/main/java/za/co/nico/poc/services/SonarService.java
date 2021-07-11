package za.co.nico.poc.services;

import java.io.IOException;
import java.net.MalformedURLException;

public interface SonarService {
	public String connectToRest(String restUrl) throws MalformedURLException,IOException;
	public String getData(String platformUrl,String sonarEndPoint);

}
