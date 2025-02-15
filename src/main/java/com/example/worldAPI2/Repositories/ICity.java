package com.example.worldAPI2.Repositories;

import com.example.worldAPI2.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICity extends JpaRepository <City, Long> {
}
