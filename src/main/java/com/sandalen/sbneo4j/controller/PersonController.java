package com.sandalen.sbneo4j.controller;

import com.sandalen.sbneo4j.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/getPerson")
    public String getPerson(){
        personService.getPerson();
        return "get success";
    }

    @RequestMapping("/savePerson")
    public String savePerson(){
        personService.addperson();
        return "success";
    }

    @RequestMapping("/addMovie")
    public String addMovie(){
        personService.addMovie();
        return "success";
    }
}
