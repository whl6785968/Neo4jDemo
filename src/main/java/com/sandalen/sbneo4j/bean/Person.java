package com.sandalen.sbneo4j.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person {
    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String sex;

    @DateLong
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create;

    @Relationship(type = "朋友" ,direction = Relationship.OUTGOING)
    @JsonIgnore
    private Set<Person> friends = new HashSet<>();

    public void addFriends(Person person){
        friends.add(person);
    }

    @Relationship(type = "评分",direction = Relationship.OUTGOING)
    private Set<Rating> ratings = new HashSet<>();

    public Rating rating(Movie movie,int stars,String comment){
        Rating rating = new Rating(this,movie,comment,stars);
        ratings.add(rating);
        return rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
}
