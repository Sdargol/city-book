package com.sdargol.DTO;

public class CountCityInRegionDTO {
    private Integer countCity;
    private String region;

    public CountCityInRegionDTO() {
    }

    public CountCityInRegionDTO(Integer countCity, String region) {
        this.countCity = countCity;
        this.region = region;
    }

    public Integer getCountCity() {
        return countCity;
    }

    public void setCountCity(Integer countCity) {
        this.countCity = countCity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
