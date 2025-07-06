package com.cognizant.ormlearn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Countries containing text (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String text);

    // 2. Countries containing text in ascending order
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    // 3. Countries starting with specific alphabet
    List<Country> findByNameStartingWith(String prefix);
}
