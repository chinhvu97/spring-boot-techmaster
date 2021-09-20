package com.tiki.bookstore.model;

public class Author {
    String name;
    int DOB;
    String country;
    String gender;

    public Author(String name, int DOB, String country, String gender) {
        this.name = name;
        this.DOB = DOB;
        this.country = country;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDOB() {
        return DOB;
    }

    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
