package com.example.footballapp.service;


import com.example.footballapp.model.Country;
import com.example.footballapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService{
    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll(){
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    public Optional<Country> getById(String id){
        return countryRepository.findById(id);
    }

    public Country save(Country country){
        countryRepository.save(country);
        return country;
    }

    public boolean  delete(String id){
        try {
            countryRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }
}
