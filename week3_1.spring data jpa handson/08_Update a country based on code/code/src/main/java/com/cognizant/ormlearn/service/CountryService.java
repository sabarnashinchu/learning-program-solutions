package com.cognizant.ormlearn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void updateCountry(String code, String newName) {
        Optional<Country> optional = countryRepository.findById(code);
        if (optional.isPresent()) {
            Country country = optional.get();
            country.setName(newName);
            countryRepository.save(country);
        } else {
            System.out.println("Country not found");
        }
    }

    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
}
