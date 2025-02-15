package com.example.worldAPI2.Services;

import com.example.worldAPI2.Models.Country;
import com.example.worldAPI2.Repositories.ICountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    ICountry countryRepository;

    //Dins els sevices feim els mètodes generals per fer les operacions crud, despres a cada controller ja els especificam

    //Select de tots els countries
    public ArrayList<Country> getCountries(){
        return (ArrayList<Country>) countryRepository.findAll();
    }

    //Select de un country per ID
    public Optional<Country> getCountriesByID(String id){
        return countryRepository.findById(id);
    }

    //Crear un country
    public Country createCountry(Country country){
        return countryRepository.save(country);
    }

    //Actualització d'un country
    public Country updateCountry(Country request, String id){
        Country country = countryRepository.findById(id).get();

        country.setCode(request.getCode());
        country.setName(request.getName());
        country.setContinent(request.getContinent());
        country.setRegion(request.getRegion());
        country.setSurfaceArea(request.getSurfaceArea());
        country.setIndepYear(request.getIndepYear());
        country.setPopulation(request.getPopulation());
        country.setLifeExpectancy(request.getLifeExpectancy());
        country.setGnp(request.getGnp());
        country.setGNPOld(request.getGNPOld());
        country.setLocalName(request.getLocalName());
        country.setGovernmentForm(request.getGovernmentForm());
        country.setHeadOfState(request.getHeadOfState());
        country.setCapital(request.getCapital());
        country.setCode2(request.getCode2());

        return country;
    }


    //Eliminar un country
    public Boolean deleteCountry(String id){
        try{
            countryRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
