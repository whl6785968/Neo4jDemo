package com.sandalen.sbneo4j.Service;

import com.sandalen.sbneo4j.bean.Movie;
import com.sandalen.sbneo4j.bean.Person;
import com.sandalen.sbneo4j.bean.Rating;
import com.sandalen.sbneo4j.repository.MovieRepository;
import com.sandalen.sbneo4j.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MovieRepository movieRepository;


    public void getPerson(){
        Iterable<Person> person = personRepository.findAll();
    }

    public void addperson(){
        Person person = new Person();
        person.setCreate(new Date());
        person.setName("张莎");
        person.setSex("女");

        Person person2 = new Person();
        person2.setCreate(new Date());
        person2.setName("余琦");
        person2.setSex("女");

        person.addFriends(person2);

        personRepository.save(person);
        personRepository.save(person2);

    }

    public void addMovie(){
        Movie movie = new Movie();
        movie.setName("绣春刀");
        Person pers = personRepository.findByName("余琦");
        Rating rating = pers.rating(movie, 10, "好看");
        rating.setCreate(new Date());
        movie.addRating(rating);

        movieRepository.save(movie);

    }
}
