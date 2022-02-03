/*
 * package com.katta.security.config;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.web.authentication.www.
 * BasicAuthenticationFilter;
 * 
 * 
 * @EnableWebSecurity
 * 
 * @Configuration public class WebsecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.addFilterBefore(authTokenFilter(), BasicAuthenticationFilter.class)
 * .authenticationProvider(new AuthTokenProvider()) .authorizeRequests()
 * .anyRequest() .authenticated(); }
 * 
 * private AuthTokenFilter authTokenFilter() throws Exception { AuthTokenFilter
 * authTokenFilter = new AuthTokenFilter();
 * authTokenFilter.setAuthenticationManager(authenticationManagerBean());
 * authTokenFilter.setAuthenticationSuccessHandler((req, res, auth) -> {});
 * authTokenFilter.setAuthenticationFailureHandler((req, res, failureHandler) ->
 * {}); return authTokenFilter; }
 * 
 * }
 */
