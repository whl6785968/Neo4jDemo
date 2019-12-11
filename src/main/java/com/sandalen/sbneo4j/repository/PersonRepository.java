package com.sandalen.sbneo4j.repository;

import com.sandalen.sbneo4j.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    Person findByName(String name);
}


