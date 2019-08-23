package com.exact.service.panel.request;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

import io.jsonwebtoken.io.IOException;

public interface IRequester {
	
	CloseableHttpResponse request(HttpUriRequest httpGet) throws ClientProtocolException, IOException;

}
