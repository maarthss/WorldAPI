package com.example.worldAPI2.Controllers;

import com.example.worldAPI2.Models.Country;
import com.example.worldAPI2.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    //Aquí implementam lo que hem fet al service

    @Autowired
    private CountryService countryService;

    //Seleccionar tots els countries
    @GetMapping
    public ArrayList<Country> getAllCountries(){
        return this.countryService.getCountries();
    }

    //Seleccionar els countries per id
    @GetMapping(path = "/{id}")
    public Optional<Country> getCountryByID(@PathVariable("id") String id){
        return this.countryService.getCountriesByID(id);
    }

    //Create un nou country
    @PostMapping
    public Country createCountry(@RequestBody Country country){
        return this.countryService.createCountry(country);
    }

    //Actualitzar un country
    @PutMapping(path = "/{id}")
    public Country updateCountry(@RequestBody Country country, @PathVariable("id") String id){
        return this.countryService.updateCountry(country, id);
    }

    //Delete un country
    @DeleteMapping(path = "/{id}")
    public String deleteCountry(@PathVariable("id") String id){
        Boolean ok = this.countryService.deleteCountry(id);

        if(ok){
            return "country with id: " + id + " deleted successfully";
        }else{
            return "Country with id: " + id + " could not be deleted";
        }
    }

}
