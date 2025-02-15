package com.example.worldAPI2.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("''")
    @JoinColumn(name = "CountryCode", nullable = false, referencedColumnName = "code")
    @JsonIgnoreProperties({"name", "continent", "region", "surfaceArea", "indepYear", "population", "lifeExpectancy", "gnp", "gnpold", "localName", "governmentForm", "headOfState", "capital", "code2", "hibernateLazyInitializer"})
    private com.example.worldAPI2.Models.Country countryCode;

    @Column(name = "District")
    private String district;

    @ColumnDefault("0")
    @Column(name = "Population", nullable = false)
    private Integer population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.worldAPI2.Models.Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(com.example.worldAPI2.Models.Country countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}