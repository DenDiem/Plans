package com.mathpar.plan._configs;

import com.mathpar.plan.utils.MathparProperties;
import com.mysql.cj.jdbc.MysqlDataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = "com.mathpar.plan.entities")
@EnableJpaRepositories(basePackages = "com.mathpar.plan.repositories")
public class DatabaseConfiguration {
    @Bean
    @Profile("!test")
    public DataSource getDatasource(MathparProperties mathparProperties){
        var datasource = new MysqlDataSource();
        datasource.setUrl(mathparProperties.getDatabaseUrl());
        datasource.setUser(mathparProperties.getDatabaseUsername());
        datasource.setPassword(mathparProperties.getDatabasePassword());
        return datasource;
    }
}
