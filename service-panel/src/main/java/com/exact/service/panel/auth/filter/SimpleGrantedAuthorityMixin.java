package com.exact.service.panel.auth.filter;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorityMixin {
	
	@JsonCreator
	public SimpleGrantedAuthorityMixin(@JsonProperty("nombre") String role) {}
	
	
}
