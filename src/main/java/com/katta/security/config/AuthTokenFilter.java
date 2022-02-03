/*
 * package com.katta.security.config;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.web.authentication.
 * AbstractAuthenticationProcessingFilter;
 * 
 * public class AuthTokenFilter extends AbstractAuthenticationProcessingFilter{
 * 
 * protected AuthTokenFilter() { super(req -> req.getHeader("auth-token") !=
 * null); }
 * 
 * @Override public Authentication attemptAuthentication(HttpServletRequest
 * request, HttpServletResponse response) throws AuthenticationException,
 * IOException, ServletException {
 * 
 * AuthTokenAuthentication authTokenAuthentication = new
 * AuthTokenAuthentication(request.getHeader("auth-token")); return
 * getAuthenticationManager().authenticate(authTokenAuthentication); }
 * 
 * @Override protected void successfulAuthentication(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain, Authentication authResult)
 * throws IOException, ServletException {
 * super.successfulAuthentication(request, response, chain, authResult);
 * chain.doFilter(request, response); }
 * 
 * @Override protected void unsuccessfulAuthentication(HttpServletRequest
 * request, HttpServletResponse response, AuthenticationException failed) throws
 * IOException, ServletException { super.unsuccessfulAuthentication(request,
 * response, failed); response.setStatus(500);
 * response.getWriter().print("Invalid auth token"); }
 * 
 * }
 */