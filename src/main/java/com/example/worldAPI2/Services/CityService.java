package com.example.worldAPI2.Services;

import com.example.worldAPI2.Models.City;
import com.example.worldAPI2.Repositories.ICity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private ICity cityRepository;

    //Select de les ciutats
    public ArrayList<City> getAllCities(){
        return (ArrayList<City>) cityRepository.findAll();
    }

    //Select d'UNA ciutat
    public Optional<City> getCityByID(Long id){
        return cityRepository.findById(id);
    }

    //Crear una city
    public City createCity(City city){
        return cityRepository.save(city);
    }

    //Actualització d'una city
    public City updateCity(City request, Long id){
        City city = cityRepository.findById(id).get();

        city.setId(request.getId());
        city.setName(request.getName());
        city.setCountryCode(request.getCountryCode());
        city.setDistrict(request.getDistrict());
        city.setPopulation(request.getPopulation());

        return city;
    }

    //Esborrat d'una city
    public boolean deleteCity(Long id){

        try{
            cityRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
