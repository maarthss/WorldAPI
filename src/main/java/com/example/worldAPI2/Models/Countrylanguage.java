package com.example.worldAPI2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "countrylanguage")
public class Countrylanguage {
    @EmbeddedId
    private CountrylanguageId id;

    @MapsId("countryCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("''")
    @JoinColumn(name = "CountryCode", nullable = false)
    @JsonIgnoreProperties({"name", "continent", "region", "surfaceArea", "indepYear", "population", "lifeExpectancy", "gnp", "gnpold", "localName", "governmentForm", "headOfState", "capital", "code2", "hibernateLazyInitializer"})
    private Country countryCode;

    @ColumnDefault("'F'")
    @Lob
    @Column(name = "IsOfficial", nullable = false)
    private String isOfficial;

    @Column(name = "percentage", nullable = false)
    private Float percentage;

    public CountrylanguageId getId() {
        return id;
    }

    public void setId(CountrylanguageId id) {
        this.id = id;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country countryCode) {
        this.countryCode = countryCode;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

}