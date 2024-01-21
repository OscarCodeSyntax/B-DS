package com.apitemplate.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/general")
public
class GeneralController {


    @GetMapping
    public String[] findAll() {

        String[] response = {"this", "is", "find", "all"};

        //Insert desired Method / logic here//
        //service.findAll()

        return response;
    }

    @GetMapping(value = "{id}")
    public String findById(@PathVariable("id") Long id) {

        //Insert desired Method / logic here//
        //service.getById()

        return "This is get by Id " + id;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody String resource) {

        //Insert desired Method / logic here//
        //service.create()

        return "This is create with resource : " + resource;
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") Long id, @RequestBody String resource) {

        //Insert desired Method / logic here//
        //service.update(resource);

        return "This is update with resource : " + resource;


    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {

        //Insert desired Method / logic here//
        // service.deleteById(id);

        return "This is delete";

    }

}