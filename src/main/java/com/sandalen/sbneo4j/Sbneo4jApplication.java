package com.sandalen.sbneo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.sandalen.sbneo4j.bean")
public class Sbneo4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(Sbneo4jApplication.class, args);
    }

}
