package com.example.worldAPI2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Embeddable
public class CountrylanguageId implements java.io.Serializable {
    private static final long serialVersionUID = 6742481869167084687L;
    @ColumnDefault("''")
    @Column(name = "CountryCode", nullable = false, length = 3)
    private String countryCode;

    @ColumnDefault("''")
    @Column(name = "Language", nullable = false, length = 30)
    private String language;

    public CountrylanguageId(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    public CountrylanguageId() {

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CountrylanguageId entity = (CountrylanguageId) o;
        return Objects.equals(this.countryCode, entity.countryCode) &&
                Objects.equals(this.language, entity.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language);
    }

}