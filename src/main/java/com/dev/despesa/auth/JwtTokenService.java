package com.dev.despesa.auth;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dev.despesa.model.UsuarioDetails;

@Service
public class JwtTokenService {

	private static final String SECRET_KEY = "4Z^XrroxR@dWxqf$mTTKwW$!@#qGr4P";
	private static final String ISSUER = "pagani-api";

	public String generateToken(UsuarioDetails usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			return JWT.create().withIssuer(ISSUER).withIssuedAt(creationDate()).withExpiresAt(expirationDate())
					.withSubject(usuario.getUsername()).sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new JWTCreationException("Erro ao gerar token.", exception);
		}
	}

	public String getSubjectFromToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			return JWT.require(algorithm).withIssuer(ISSUER).build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			throw new JWTVerificationException("Token inválido ou expirado.");
		}
	}

	private Date creationDate() {
		return Date.from(ZonedDateTime.now(ZoneId.of("America/Recife")).toInstant());
	}

	private Date expirationDate() {
		return Date.from(ZonedDateTime.now(ZoneId.of("America/Recife")).plusHours(400).toInstant());
	}

}
