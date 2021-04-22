package com.javainuse.taskconfig;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
@Service
public class ReprocessService {
	
	
	 private static final String urlBase = "https://jsonplaceholder.typicode.com/todos/1";
	 
	  public static void invokeReprocessAPI() {
	        final String uri = urlBase + "/test/assigned";

	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            try{
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	        String resultBody = result.getBody();
            } catch (HttpStatusCodeException ex) {
            	System.out.println("unable to invoke...."+ex);
            	String resultBody = ex.getResponseBodyAsString();
            }

	        
	    }

}
