package za.co.nico.poc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.wsclient.SonarClient;
import org.springframework.stereotype.Service;

import za.co.nico.poc.dtos.GetWsRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.sonarqube.ws.client.GetRequest;
import org.sonarqube.ws.client.HttpConnector;
import org.sonarqube.ws.client.WsClient;
import org.sonarqube.ws.client.WsClientFactories;
import org.sonarqube.ws.client.WsRequest;
import org.sonarqube.ws.client.WsRequest.Method;
import org.sonarqube.ws.client.WsResponse;

/**
 * 
 * https://www.baeldung.com/java-http-request
 * 
 */
@Service
public class SonarServiceImpl implements SonarService {
	private static final Logger log = LoggerFactory.getLogger(SonarServiceImpl.class);
	
	private final String TOKEN="2ce06b3585c34141beeeb4005235337ba2bd135d"; 

	@Override
	public String connectToRest(String restUrl) throws MalformedURLException, IOException {
		log.info("REST Url : " + restUrl);
		

		BufferedReader in = null;
		StringBuffer content = null;
		String result = null;
		HttpURLConnection con = null;

		try {
			URL url = new URL(restUrl);
			
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.setRequestProperty("Authorization", "Basic " + TOKEN); //Base64.encodeBase64(url.getUserInfo().getBytes()));

			int status = con.getResponseCode();
			log.info("Response Code : " + status);
			
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				log.info("Response Code : is " + HttpURLConnection.HTTP_OK);
			} else {
				log.error("Response Code : is not " + HttpURLConnection.HTTP_OK);				
			}

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			log.debug("Content: " + content);
			if (content != null) {
				result = content.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed to call REST API", e);
		} finally {
			if (in != null) {
				in.close();
			}
			if (con != null) {
				con.disconnect();
			}
		}

		return result;
		
	}
	
	/**
	 * https://shanchathusanda.medium.com/https-medium-com-shanchathusanda-integrating-sonarqube-apis-with-a-java-application-de8fdc8b951f
	 * https://www.codota.com/code/java/methods/org.sonarqube.ws.client.HttpConnector$Builder/token
	 * 
	 * https://programtalk.com/java-api-usage-examples/org.sonarqube.ws.client.WsClient/
	 * 
	 */
	public String getData(String restUrl,String sonarEndPoint) {

		restUrl="http://localhost:9001/";

		String login="admin";
		String password="admin";
		WsClient wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials(login, password).build());
	    WsResponse response = wsClient.wsConnector().call(new GetRequest("api/authentication/validate"));
	    String content = response.content();
	    log.debug(""+response.isSuccessful());
	    log.debug(""+response.code());
	    
//	    wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials(login, password).build());
	    response = wsClient.wsConnector().call(new GetRequest("api/components/search_projects"));
	    log.debug(""+response.isSuccessful());
	    content = response.content();
	    log.debug(""+response.code());
	    
	    
	    wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials("admin", "admin").build());
	    response = wsClient.wsConnector().call(new GetRequest("local_ws_call/require_permission"));
	    log.debug(""+response.isSuccessful());
	    log.debug(""+response.code());

	    wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials(login, password).build());
	    response = wsClient.wsConnector().call(new GetRequest("api/rules/search"));
	    log.debug(""+response.isSuccessful());
	    log.debug(""+response.code());



		
		return "";
	}

}
