package com.example.footballapp.service.Country;


import com.example.footballapp.model.Country;
import com.example.footballapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImplementation implements CountryService{
    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll(){
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }
    @Override
    public Optional<Country> getById(String id){
        return countryRepository.findById(id);
    }
    @Override
    public Country save(Country country){
        countryRepository.save(country);
        return country;
    }
    @Override
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
