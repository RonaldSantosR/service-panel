package com.exact.service.panel.request;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.io.IOException;

@Service
public class Requester implements IRequester{

	private CloseableHttpClient httpClient;
	private CloseableHttpResponse response;
	
	public Requester() {
		httpClient = HttpClients.createDefault();
	}
	
	@Override
	public CloseableHttpResponse request(HttpUriRequest httpGet) throws IOException{
		try {
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
