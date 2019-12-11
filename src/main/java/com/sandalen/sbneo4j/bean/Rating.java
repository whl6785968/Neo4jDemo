package com.sandalen.sbneo4j.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@RelationshipEntity(type = "评分")
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    @JsonBackReference
    private Person person;

    @EndNode
    @JsonBackReference
    private Movie movie;

    private String comment;
    private int stars;

    @DateLong
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create;

    public Rating(Person person, Movie movie, String comment, int stars) {
        this.person = person;
        this.movie = movie;
        this.comment = comment;
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
