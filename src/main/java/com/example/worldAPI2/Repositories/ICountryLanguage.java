package com.example.worldAPI2.Repositories;

import com.example.worldAPI2.Models.Countrylanguage;
import com.example.worldAPI2.Models.CountrylanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryLanguage extends JpaRepository<Countrylanguage, CountrylanguageId> {
}
