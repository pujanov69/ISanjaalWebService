package com.ishani.isanjaalwebservice;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class IsanjalwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsanjalwebserviceApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix ="spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
	
}
