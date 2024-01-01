package com.apitemplate.dataservice.service;

import com.apitemplate.dataservice.repositories.PersonRepository;
import com.apitemplate.dataservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    @Autowired
    private PersonRepository repository;

    public void savePerson(Person user) {
        repository.save(user);
    }
    public Person getPerson(String id) {
        return repository.findById(id).orElse(null);
    }
    public List<Person> getAllPeople(){
        return repository.findAll();
    }
    public void deletePerson(String id) {
        repository.deleteById(id);
    }

    public void updateNameByName(String oldName, String newName) {
        repository.updateNameByName(oldName, newName);
    }

    public void updateAgeByName(String currentName, int newAge) {
        repository.updateAgeByName(currentName, newAge);
    }
}