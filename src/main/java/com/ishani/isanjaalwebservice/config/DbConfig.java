package com.ishani.isanjaalwebservice.config;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import com.ishani.isanjaalwebservice.database.Mapper.BeanMapperSnakeCaseFactory;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.ishanitech")
public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Bean
    public TransactionAwareDataSourceProxy TransactionAwareDataSourceProxy() {
    	return new TransactionAwareDataSourceProxy(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
    	return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public DBI dbiBean(TransactionAwareDataSourceProxy dataSource) {
        DBI jdbi = new DBI(dataSource);
        jdbi.registerMapper(new BeanMapperSnakeCaseFactory());
        return jdbi;

    }
}
