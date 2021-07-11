package za.co.nico.poc.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonarqube.ws.client.GetRequest;
import org.sonarqube.ws.client.HttpConnector;
import org.sonarqube.ws.client.WsClient;
import org.sonarqube.ws.client.WsClientFactories;
import org.sonarqube.ws.client.WsResponse;
import org.springframework.stereotype.Service;

 

/**
 * 
 * https://www.baeldung.com/java-http-request
 * https://stackoverflow.com/questions/68334452/i-am-unable-to-call-the-sunarqube-api-from-java-to-search-for-issues-get-410-err
 * 
 */
@Service
public class SonarServiceImpl implements SonarService {
	private static final Logger log = LoggerFactory.getLogger(SonarServiceImpl.class);
	
	private final String TOKEN="2ce06b3585c34141beeeb4005235337ba2bd135d"; 

	private final String USERNAME="admin";
	private final String PASSWORD="admin";
	
//	private final OkHttpClient client = new OkHttpClient();
	
	/**
	 * https://programtalk.com/java-api-usage-examples/org.sonarqube.ws.client.WsClient/
	 */
	@Override
	public String getData(String restUrl,String sonarEndPoint) {

		log.debug(" restUrl : "+restUrl+" sonarEndPoint : "+sonarEndPoint); // restUrl : http://localhost:9001/ sonarEndPoint : api/components/search_projects

		String scheeme="";
		
		String host="localhost";
		int port=9001;
		
		List<String> pathSegments =new ArrayList<>();		
		List<String> queryNamesAndValues =new ArrayList<>();
		String fragment="";
		
		
		WsClient wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials(USERNAME, PASSWORD).build());
	    WsResponse response = wsClient.wsConnector().call(new GetRequest("api/authentication/validate"));
	    String content = response.content();
	    log.debug(""+response.isSuccessful());
	    log.debug(""+response.code()); //200

	    response = wsClient.wsConnector().call(new GetRequest("api/components/search_projects"));
	    log.debug(""+response.isSuccessful());
	    content = response.content();
	    log.debug(""+response.code()); //401
	    
	    
	    wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials("admin", "admin").build());
	    response = wsClient.wsConnector().call(new GetRequest("local_ws_call/require_permission"));
	    log.debug(""+response.isSuccessful());
	    log.debug(""+response.code()); // 200

	    wsClient = WsClientFactories.getDefault().newClient(HttpConnector.newBuilder().url(restUrl).credentials(USERNAME, PASSWORD).build());
	    response = wsClient.wsConnector().call(new GetRequest("api/rules/search"));
	    log.debug(""+response.isSuccessful());
	    log.debug(""+response.code()); // 401
		
		
		return "";
	}

	/**
	 * 
	 * https://www.jenkins.io/doc/book/system-administration/authenticating-scripted-clients/
	 * 
	 * 
vi /opt/sonarqube/conf/sonar.properties
         
# SSO AUTHENTICATION                                                                                          
                                                                                                              
# Enable authentication using HTTP headers                                                                    
###NICO ADDED###                                                                                        
sonar.web.sso.enable=false

	 */
	@Override
	public String connectToRest(String restUrl) throws MalformedURLException, IOException {
		log.debug("restUrl "+restUrl);
		String result = null;
		
		URI uri = URI.create(restUrl);
		HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(uri.getHost(), uri.getPort()),
            new UsernamePasswordCredentials(USERNAME, PASSWORD));
     // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
     // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(host, basicAuth);
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        HttpGet httpGet = new HttpGet(uri);
		try {
     // Add AuthCache to the execution context
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);
        HttpResponse response = httpClient.execute(host, httpGet, localContext);
        log.debug("response " + response);
        result = EntityUtils.toString(response.getEntity());
		


			log.debug("result " + result);
		} catch (Exception e) {
			e.printStackTrace(); // org.springframework.web.client.RestTemplate - Response 401 UNAUTHORIZED
		}
		return result;
	}

}
