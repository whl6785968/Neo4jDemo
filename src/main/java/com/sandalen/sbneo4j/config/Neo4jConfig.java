package com.sandalen.sbneo4j.config;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.sandalen.sbneo4j.repository")
@EnableTransactionManagement
public class Neo4jConfig {

    @Bean
    public SessionFactory sessionFactory(){
        return new SessionFactory(configuration(),"com.sandalen.sbneo4j.bean");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration(){
        ClasspathConfigurationSource source = new ClasspathConfigurationSource("ogm.properties");
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(source).build();
        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }
}
