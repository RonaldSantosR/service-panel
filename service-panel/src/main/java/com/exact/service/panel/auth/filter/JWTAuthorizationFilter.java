package com.exact.service.panel.auth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	


	@SuppressWarnings("unchecked")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");
		
		if (!requiresAuthentication(header)) {
			return;
		}
		
		Claims claims = null;
		
		try {			
			claims = Jwts.parser()
			.setSigningKey("1234567890.abcdefghi.qwerty.1234567890".getBytes())
			.parseClaimsJws(header.replace("Bearer ", "")).getBody();
		}catch (ExpiredJwtException eje) {
			response.setStatus(894);	
			response.sendError(894, "EL TOKEN ENVIADO HA EXPIRADO");
			return;
		}catch (MalformedJwtException mje) {
			response.setStatus(498);
			response.sendError(498, "EL TOKEN ENVIADO ES INVÁLIDO");
			return;
		}catch (SignatureException se) {
			response.setStatus(498);
			response.sendError(498, "EL TOKEN ENVIADO ES INVÁLIDO");
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = null;
		Long idUsuario = Long.valueOf(claims.get("idUsuario").toString());
		String matricula = (String) claims.get("matricula");
		String perfil = claims.get("perfil").toString();
		String usuario = claims.get("usuario").toString();
		Map<String, Object> datosUsuario = new HashMap<String, Object>();
		datosUsuario.put("idUsuario", idUsuario);
		datosUsuario.put("matricula", matricula);
		datosUsuario.put("perfil", perfil);
		datosUsuario.put("usuario", usuario);
		Object permisos = claims.get("permisos");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		((ArrayList<Map<String, Object>>) new ObjectMapper()
				.readValue(permisos.toString().getBytes(), ArrayList.class)).stream().forEach(
				permiso -> {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permiso.get("nombre").toString());
					authorities.add(grantedAuthority);
				}
		);
		datosUsuario.put("permisos", permisos);
		authentication = new UsernamePasswordAuthenticationToken(datosUsuario, null, authorities);		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
		
	}

	protected boolean requiresAuthentication(String header) {
		if (header == null || !header.startsWith("Bearer ")) {
			return false;
		}
		return true;
	}

}
