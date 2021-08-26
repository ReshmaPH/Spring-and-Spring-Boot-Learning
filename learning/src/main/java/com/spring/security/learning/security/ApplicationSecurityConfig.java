package com.spring.security.learning.security;

import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

import com.spring.security.learning.auth.ApplicationUser;
import com.spring.security.learning.auth.ApplicationUserService;
import com.spring.security.learning.filter.CsrfLoggerFilter;
import com.spring.security.learning.jwt.JwtConfig;
import com.spring.security.learning.jwt.JwtTokenVerifier;
import com.spring.security.learning.jwt.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private final PasswordEncoder passwordEncoder;
	private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     ApplicationUserService applicationUserService,
                                     SecretKey secretKey,
                                     JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

	//configure the basic authentication for the default user and white listing root url.
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		//	.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		//	.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     // making stateless for addin jwt filter
			.and()
			.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(),jwtConfig, secretKey))  //jwt filter
			.addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class)
			.authorizeRequests()  
			.antMatchers("/","index")  // white listing
			.permitAll()
			.antMatchers("/api/**")
			.hasRole(ApplicationUserRole.STUDENT.name())  //commenting below as preauthorize annotations are used in controller
//			.antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(),ApplicationUserRole.ADMINTRAINEE.name())
			.anyRequest()
			.authenticated();  //commenting below as form based auth is not in use.
	/*		.and()
	//		.httpBasic();   // enforcing basic authentication
			.formLogin()  // form based auth
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/courses") // redirect to default page on successful login
			.and()
			.rememberMe() //by default 2 weeks
			.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) //modifying expiration time
			.key("somethingverysecured")
			.and()
			.logout()
			.logoutUrl("/logout")   // 
			.clearAuthentication(true)//
			.invalidateHttpSession(true)//clearing session ids and all during log out
			.deleteCookies("JSESSIONID","remember-me")
			.logoutSuccessUrl("/login");
		*/
		//http.addFilterAfter(new CsrfLoggerFilter(), CsrfFilter.class);  //used to get csrf token in header
	}


	
	//Creating an in memory user by encrypting pwd
/*	@Bean  --commenting this out to use ApplicationUserService 
	protected UserDetailsService userDetailsService(){
			UserDetails userResh = User.builder()
			.username("Resh")
			.password(passwordEncoder.encode("password"))
			//.roles(ApplicationUserRole.STUDENT.name())
			.authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
			.build();
			
			UserDetails userLohi =User.builder()
								.username("Lohi")
								.password(passwordEncoder.encode("password123"))
								//.roles(ApplicationUserRole.ADMIN.name())
								.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
								.build();
			
			
			UserDetails userRisha=User.builder()
								.username("Risha")
								.password(passwordEncoder.encode("password123"))
								//.roles(ApplicationUserRole.ADMINTRAINEE.name())
								.authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
								.build();
		return new InMemoryUserDetailsManager(userResh,userLohi,userRisha);
		
	} */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);
		return provider;		
	}
	
}
