package com.example.worldAPI2.Repositories;

import com.example.worldAPI2.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountry extends JpaRepository<Country, String> {
}
