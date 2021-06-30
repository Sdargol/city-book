package com.sdargol.service;

import com.sdargol.DTO.CountCityInRegionDTO;
import com.sdargol.entity.City;

import java.util.List;
import java.util.Optional;

public interface ICityBookService {
    List<City> getAll();

    List<City> getAllSortByAlphabet();

    List<City> getAllSortByDistrictAndName();

    Optional<City> searchCityMaxPopulation();

    List<CountCityInRegionDTO> getCountCityInRegion();
}
