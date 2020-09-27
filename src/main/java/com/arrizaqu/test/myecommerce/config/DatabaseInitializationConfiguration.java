package com.arrizaqu.test.myecommerce.config;

import javax.sql.DataSource;

import org.postgresql.core.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration(proxyBeanMethods = false)
public class DatabaseInitializationConfiguration {

    @Autowired
    void initializeDatabase(DataSource connectionFactory) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource[] scripts = new Resource[] { 
        		resourceLoader.getResource("classpath:data.sql") };
        new ResourceDatabasePopulator(scripts).execute(connectionFactory);
    }

}