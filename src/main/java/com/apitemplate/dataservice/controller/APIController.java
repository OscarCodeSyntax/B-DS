package com.apitemplate.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apiController/")
public
class APIController {

    @CrossOrigin
    @GetMapping
    public String[] findAll() {
        String[] response = {"get", "mapping", "find", "all"};
        //Insert desired Method / logic here
//        return service.findAll();
        return response;
    }

    @CrossOrigin
    @GetMapping(value = "{id}")
    public String findById(@PathVariable("id") Long id) {
        //Insert desired Method / logic here
//        return RestPreconditions.checkFound(service.findById(id));
        return "get by Id reached : " + id;
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody String resource) {

        //Insert desired Method / logic here
//        Preconditions.checkNotNull(resource);
//        return service.create(resource);
        return "create reached : " + resource;
    }

    @CrossOrigin
    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody String resource) {
        //Insert desired Method / logic here
//        Preconditions.checkNotNull(resource);
//        RestPreconditions.checkNotNull(service.getById(resource.getId()));
//        service.update(resource);
    }

    @CrossOrigin
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        //Insert desired Method / logic here (delete method)
//        service.deleteById(id);
    }

}