package com.sdargol.entity;

public class CityBuilder {
    private int id;
    private String name;
    private String region;
    private String district;
    private int population;
    private short foundation;

    public CityBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CityBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public CityBuilder setDistrict(String district) {
        this.district = district;
        return this;
    }

    public CityBuilder setPopulation(int population) {
        this.population = population;
        return this;
    }

    public CityBuilder setFoundation(short foundation) {
        this.foundation = foundation;
        return this;
    }

    public City build(){
        return new City(id,name,region,district,population,foundation);
    }
}
