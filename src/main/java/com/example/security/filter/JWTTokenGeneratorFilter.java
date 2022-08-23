package com.example.security.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.security.constants.SecurityConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null != authentication) {
			//secret word
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
			//setIssuer ==> émetteur
			String jwt = Jwts.builder().setIssuer("Ayoub").setSubject("JWT Token")
					//claims are values of payload
						.claim("username", authentication.getName())
					  .claim("authorities", populateAuthorities(authentication.getAuthorities()))
					  .setIssuedAt(new Date())
					//Expiration in ms
					.setExpiration(new Date((new Date()).getTime() + 3000000000L))
					.signWith(key).compact();
			response.setHeader(SecurityConstants.JWT_HEADER, jwt);
		}

		chain.doFilter(request, response);
	}


	//this filter will be executed only if request.getServletPath().equals("/user")
	//==> this filter should not be applied for the login request
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return !request.getServletPath().equals("/user");
	}
	
	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
        	authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
	}
}
