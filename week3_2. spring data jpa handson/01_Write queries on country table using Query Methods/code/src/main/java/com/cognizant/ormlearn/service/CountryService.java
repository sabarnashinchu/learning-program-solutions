package com.cognizant.ormlearn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountriesContaining(String text) {
        return countryRepository.findByNameContainingIgnoreCase(text);
    }

    public List<Country> getCountriesContainingSorted(String text) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(text);
    }

    public List<Country> getCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
