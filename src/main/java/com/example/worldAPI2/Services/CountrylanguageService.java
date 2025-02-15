package com.example.worldAPI2.Services;

import com.example.worldAPI2.Models.Countrylanguage;
import com.example.worldAPI2.Models.CountrylanguageId;
import com.example.worldAPI2.Repositories.ICountryLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CountrylanguageService {

    @Autowired
    ICountryLanguage countryLanguageRepository;

    //Select dels country languages
    public ArrayList<Countrylanguage> getAllCountryLanguages(){
        return (ArrayList<Countrylanguage>) countryLanguageRepository.findAll();
    }

    //Select de nomes un country language
    public Optional<Countrylanguage> getCountryLanguageByID(CountrylanguageId id){
        return countryLanguageRepository.findById(id);
    }

    //Crear un nou countryLanguage
    public Countrylanguage createCountryLanguage(Countrylanguage countrylanguage){
        return countryLanguageRepository.save(countrylanguage);
    }

    //Actualitzar un country language
    public Countrylanguage updateCountryLanguage(Countrylanguage request, CountrylanguageId id){
        Countrylanguage countrylanguage = countryLanguageRepository.findById(id).get();

        countrylanguage.setId(request.getId());
        countrylanguage.setCountryCode(request.getCountryCode());
        countrylanguage.setIsOfficial(request.getIsOfficial());
        countrylanguage.setPercentage(request.getPercentage());

        return countrylanguage;
    }

    //Esborrar un countryLanguage
    public Boolean deleteCountryLanguage(CountrylanguageId id){
        try{
            countryLanguageRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
