package com.ishani.isanjaalwebservice.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ishani.isanjaalwebservice.security.CustomAccessDeniedHandler;
import com.ishani.isanjaalwebservice.security.CustomAuthenticationEntryPoint;
import com.ishani.isanjaalwebservice.security.CustomUserAuthenticationProvider;
import com.ishani.isanjaalwebservice.security.JWTAuthenticationFilter;
import com.ishani.isanjaalwebservice.security.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserAuthenticationProvider customUserAuthenticationProvider;
    //private final CustomCustomerAuthenticationProvider customCustomerAuthenticationProvider;
    @Autowired
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    
    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;
    
    public WebSecurityConfig(CustomUserAuthenticationProvider customUserAuthenticationProvider){
        this.customUserAuthenticationProvider = customUserAuthenticationProvider;
        //this.customCustomerAuthenticationProvider = customCustomerAuthenticationPrlearovider;
    }
 


	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customUserAuthenticationProvider);
        //auth.authenticationProvider(customCustomerAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
		http.cors().and().csrf().disable()
		.httpBasic().disable()
		.exceptionHandling()
		.accessDeniedHandler(customAccessDeniedHandler)
		.authenticationEntryPoint(customAuthenticationEntryPoint)
		.and()
		.authorizeRequests()
                .antMatchers("/Pictures/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1/users/register").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/users/checkUserName").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/users/checkDuplicateEmail").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/users/activateUser").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
