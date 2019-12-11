package com.sandalen.sbneo4j.repository;

import com.sandalen.sbneo4j.bean.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}
