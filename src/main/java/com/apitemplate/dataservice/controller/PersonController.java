package com.apitemplate.dataservice.controller;

import com.apitemplate.dataservice.model.Person;
import com.apitemplate.dataservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List findAll() {
        List response = personService.getAllPeople();
        return response;
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") String id) {
        Person person = personService.getPerson(id);
        return person;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Person person) {
        personService.savePerson(person);
        return "create reached : " + person;
    }

    @PutMapping(value = "/{newName}")
    @ResponseStatus(HttpStatus.OK)
    public void updateName(@PathVariable("newName") String newName, @RequestBody Person person) {
        personService.updateNameByName(person.getName(), newName);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }
}

