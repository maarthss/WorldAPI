package com.example.worldAPI2.Controllers;

import com.example.worldAPI2.Models.City;
import com.example.worldAPI2.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    //Select de totes les ciutats
    @GetMapping
    public ArrayList<City> getCities(){
        return this.cityService.getAllCities();
    }

    //Select d'una ciutat
    @GetMapping(path = "/{id}")
    public Optional<City> getCityByID(@PathVariable("id") Long id){
        return this.cityService.getCityByID(id);
    }

    //Crear una ciutat
    @PostMapping
    public City createCity(@RequestBody City city){
        return this.cityService.createCity(city);
    }

    //Actualitzar una city
    @PutMapping(path = "/{id}")
    public City updateCity(@RequestBody City city, @PathVariable("id") Long id){
        return this.cityService.updateCity(city, id);
    }

    //Esborrar una city
    @DeleteMapping(path = "/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        boolean ok = this.cityService.deleteCity(id);
        if (ok){
            return "City with id " + id + " was deleted";
        }else{
            return "City with id " + id + " could not be deleted";
        }
    }



}
