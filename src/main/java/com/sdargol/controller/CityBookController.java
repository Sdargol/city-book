package com.sdargol.controller;

import com.sdargol.DTO.CountCityInRegionDTO;
import com.sdargol.entity.City;
import com.sdargol.service.ICityBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/cities")
public class CityBookController {
    private final ICityBookService cityBookService;

    @Autowired
    public CityBookController(ICityBookService cityBookService) {
        this.cityBookService = cityBookService;
    }

    @GetMapping
    public ResponseEntity<List<City>> cities(){
        return new ResponseEntity<>(cityBookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<City>> citiesSorted(){
        return new ResponseEntity<>(cityBookService.getAllSortByAlphabet(), HttpStatus.OK);
    }

    @GetMapping("/sorted-district-name")
    public ResponseEntity<List<City>> citiesSortedByDistrictAndName(){
        return new ResponseEntity<>(cityBookService.getAllSortByDistrictAndName(), HttpStatus.OK);
    }

    @GetMapping("/max-population")
    public ResponseEntity<City> getCityMaxPopulation(){
        City city = cityBookService.searchCityMaxPopulation().orElse(new City());

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/population-region")
    public ResponseEntity<List<CountCityInRegionDTO>> getPopulationsInRegion(){
        return new ResponseEntity<>(cityBookService.getCountCityInRegion(), HttpStatus.OK);
    }
}
