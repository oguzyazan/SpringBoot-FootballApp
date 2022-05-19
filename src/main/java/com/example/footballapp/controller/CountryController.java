package com.example.footballapp.controller;


import com.example.footballapp.model.Country;
import com.example.footballapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/country")
public class
CountryController {

    @Autowired
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value="/getAll")
    public List<Country> getAllBooks(){
        return countryService.getAll();
    }

    @GetMapping(value="/getById")
    public Optional<Country> getById(@RequestParam String id){
        return countryService.getById(id);
    }

    @PostMapping(value = "/save")
    public Country save(@RequestBody Country country){
        return countryService.save(country);
    }
    @DeleteMapping(value = "/delete")
    public boolean  delete(@RequestParam String id){
        return countryService.delete(id);
    }
}
