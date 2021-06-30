package com.sdargol;

import com.sdargol.entity.City;
import com.sdargol.entity.CityBuilder;
import com.sdargol.loader.ILoader;
import com.sdargol.service.CityBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

public class CityBookServiceTest {
    @Mock
    private ILoader<City> mockLoader;

    @InjectMocks
    private CityBookService cityBookService;

    private final City cityOne;
    private final City cityTwo;
    private final City cityThree;

    public CityBookServiceTest(){
        cityOne = new CityBuilder()
                .setId(0)
                .setName("Name")
                .setRegion("Region")
                .setDistrict("District")
                .setPopulation(100)
                .setFoundation((short)1900)
                .build();

        cityTwo = new CityBuilder()
                .setId(1)
                .setName("AName")
                .setRegion("ARegion")
                .setDistrict("ADistrict")
                .setPopulation(10000)
                .setFoundation((short)1950)
                .build();

        cityThree = new CityBuilder()
                .setId(2)
                .setName("BName")
                .setRegion("ARegion")
                .setDistrict("ADistrict")
                .setPopulation(100000)
                .setFoundation((short)1951)
                .build();
    }

    @Test
    public void testCityBookService(){
        MockitoAnnotations.openMocks(this);

        Mockito.when(mockLoader.load()).thenReturn(
                new ArrayList<>(Arrays.asList(cityOne, cityTwo, cityThree))
        );

        Assertions.assertEquals(3, cityBookService.getAll().size());

        Assertions.assertEquals(0, cityBookService.getAll().get(0).getId());

        Assertions.assertEquals(1, cityBookService.getAllSortByAlphabet().get(0).getId());

        Assertions.assertEquals(2,
                cityBookService.getAllSortByDistrictAndName().get(1).getId());

        Assertions.assertEquals(2,
                cityBookService.searchCityMaxPopulation().get().getId());

        Assertions.assertTrue(cityBookService.searchCityMaxPopulation().isPresent());

        Assertions.assertEquals(2,
                cityBookService.getCountCityInRegion().get(0).getCountCity());
    }
}
