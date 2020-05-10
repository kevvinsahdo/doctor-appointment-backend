package com.doctorappointment.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	static final long EXPIRATION_TIME = 60 * 60 * 60 * 60;
	static final String SECRET = "MySecret";

	public String generateToken(String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		return JWT;
	}

	public String getAuthentication(String token) {
		String user = null;

		try {
			user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace("Bearer", "")).getBody()
					.getSubject();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}
}
