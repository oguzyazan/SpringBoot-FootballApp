package com.example.footballapp.service.Country;

import com.example.footballapp.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAll();
    Optional<Country> getById(String id);
    Country save(Country country);
    boolean delete(String id);
}
