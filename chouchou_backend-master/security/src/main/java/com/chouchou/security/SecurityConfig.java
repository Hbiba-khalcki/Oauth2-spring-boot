package com.chouchou.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chouchou.dao.UserRepository;
import com.chouchou.security.oauth2.CustomOAuth2UserService;
import com.chouchou.security.oauth2.CustomRequestEntityConverter;
import com.chouchou.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.chouchou.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.chouchou.security.oauth2.Oauth2AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomOAuth2UserService  customOAuth2UserService;

	private final AppProperties appProperties;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;

	public SecurityConfig(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
	
	@Bean
	public FilterRegistrationBean oauth2ClientFilterRegistration(
	    OAuth2ClientContextFilter filter) {
	  FilterRegistrationBean registration = new FilterRegistrationBean();
	  registration.setFilter(filter);
	  registration.setOrder(-100);
	  return registration;
	}

	@Bean
	@Primary
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	@Bean
	@Primary
	public BCryptPasswordEncoder getpce()
	{
		return new BCryptPasswordEncoder();
	}

	public static String hash(String password,int row) {
		return BCrypt.hashpw(password, BCrypt.gensalt(row));
	}


	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
				.userDetailsService(userDetailsService())
				.passwordEncoder(bCryptPasswordEncoder);
	}
	@Bean
	public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient(){
		DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient =
				new DefaultAuthorizationCodeTokenResponseClient();
		accessTokenResponseClient.setRequestEntityConverter(new CustomRequestEntityConverter());
		return accessTokenResponseClient;
	}
	@Bean
	public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
		return new HttpCookieOAuth2AuthorizationRequestRepository();
	}
	@Autowired
	private Oauth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

	@Autowired
	private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
				cors().disable()
				.csrf().disable()
				.formLogin().disable()
				.httpBasic().disable()
				.exceptionHandling()
				.authenticationEntryPoint(new RestAuthentificationEntryPoint())
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests()
				.antMatchers("/auth", "/index.html", "/js/**", "/img/**", "/css/**", "/static/img/**", "static/**").permitAll()
				.and().authorizeRequests()
				.antMatchers("/static/img/**", "/api/user/account/reset_password/init/**",
						"/api/user/account/reset_password",
						"/api/startProcess", "/login", "/index.html",
						"/js/**", "/img/**", "/css/**", "/user/**","/oauth2/**","/**").permitAll()
				.and().authorizeRequests().anyRequest().permitAll()
				.and()
				.addFilter(new JWTAuthentificationFilter(authenticationManager()))
				.addFilterBefore(new JWTAuthorizationFilter(appProperties), UsernamePasswordAuthenticationFilter.class)
				.oauth2Login()
				.authorizationEndpoint()
				.baseUri("/oauth2/authorize")
				.and()
				.redirectionEndpoint()
				.baseUri("/oauth2/callback/*")
				.and()
				.tokenEndpoint()
				.accessTokenResponseClient(accessTokenResponseClient())
				.and()
				.userInfoEndpoint()
				.userService(customOAuth2UserService)
				.and()
				.successHandler(oAuth2AuthenticationSuccessHandler)
				.failureHandler(oAuth2AuthenticationFailureHandler);

	}


}




