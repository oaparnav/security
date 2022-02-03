/*
 * package com.katta.security.config;
 * 
 * import org.springframework.security.authentication.AuthenticationProvider;
 * import org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @Slf4j public class AuthTokenProvider implements AuthenticationProvider {
 * 
 * @Override public Authentication authenticate(Authentication authentication)
 * throws AuthenticationException { String token = (String)
 * authentication.getPrincipal(); if (!("abc".equals(token))) {
 * authentication.setAuthenticated(false); }
 * log.info(">>>>Authentication successful");
 * authentication.setAuthenticated(true); return authentication; }
 * 
 * @Override public boolean supports(Class<?> authentication) { return
 * AuthTokenAuthentication.class.isAssignableFrom(authentication); }
 * 
 * }
 */