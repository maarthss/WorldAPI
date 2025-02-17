package com.example.worldAPI2.Controllers;

import com.example.worldAPI2.Models.Countrylanguage;
import com.example.worldAPI2.Models.CountrylanguageId;
import com.example.worldAPI2.Services.CountrylanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/countrylanguage")
public class CountrylanguageController {

    @Autowired
    private CountrylanguageService countrylanguageService;

    //Seleccionar tots els countrylanguage
    @GetMapping
    public ArrayList<Countrylanguage> getAllCountryLanguages(){
        return this.countrylanguageService.getAllCountryLanguages();
    }

    //Retornar UN countryLanguage
    @GetMapping("/{countryCode}/{language}")
    public Optional<Countrylanguage> getCountryLanguageByID(@PathVariable String countryCode, @PathVariable String language){

        CountrylanguageId id = new CountrylanguageId(countryCode, language);

        return this.countrylanguageService.getCountryLanguageByID(id);
    }

    //Creae un country language
    @PostMapping
    public Countrylanguage createCountryLanguage(@RequestBody Countrylanguage countrylanguage){
        return this.countrylanguageService.createCountryLanguage(countrylanguage);
    }

    //Actualitzar un country language
    @PutMapping(path = "/{countryCode}/{language}")
    public Countrylanguage updateCountryLanguage(@RequestBody Countrylanguage countrylanguage, @PathVariable String countryCode, @PathVariable String language){
        CountrylanguageId id = new CountrylanguageId(countryCode, language);

        return this.countrylanguageService.updateCountryLanguage(countrylanguage, id);
    }

    //Esborrar un countrylanguage
    @DeleteMapping(path = "/{countryCode}/{language}")
    public String deleteCountryLanguage(@PathVariable String countryCode, @PathVariable String language){
        CountrylanguageId id = new CountrylanguageId(countryCode, language);

        boolean ok = this.countrylanguageService.deleteCountryLanguage(id);

        if(ok){
            return "Country language with id: " + id + " was successfully deleted";
        }else{
            return "Country language with id: " + id + " could not be deleted";
        }
    }
}
