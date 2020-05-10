package com.doctorappointment.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private JwtTokenUtil jwtUtil;

	private UserDetailsService userDetailsService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JwtTokenUtil jwtUtil, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer")) {
			UsernamePasswordAuthenticationToken auth = getAuthentication(request);
			if (auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}

		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		String user = jwtUtil.getAuthentication(token);
		
		if (user == null) {
			return null;
		}
		
		UserDetails userDetail = userDetailsService.loadUserByUsername(user);
		
		return new UsernamePasswordAuthenticationToken(userDetail, null, Collections.emptyList());
	}
}
