package com.apitemplate.dataservice.repositories;

import com.apitemplate.dataservice.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("{ 'name' : ?0 }")
    @Update("{$set :{ 'name' : ?1 }}")
    void updateNameByName(String oldName, String newName);

    @Query("{ 'name' : ?0 }")
    @Update("{$set :{ 'age' : ?1 }}")
    void updateAgeByName(String name, int age);


}