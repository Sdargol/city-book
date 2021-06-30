package com.sdargol;

import com.sdargol.entity.City;
import com.sdargol.entity.CityBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class CityBuilderTest {
    @Test
    public void cityTest(){
        City city = new CityBuilder()
                .setId(0)
                .setName("Name")
                .setRegion("Region")
                .setDistrict("District")
                .setPopulation(100)
                .setFoundation((short)1900)
                .build();

        Assertions.assertEquals(0, city.getId());
        Assertions.assertEquals("Name", city.getName());
        Assertions.assertEquals("Region", city.getRegion());
        Assertions.assertEquals("District", city.getDistrict());
        Assertions.assertEquals(100, city.getPopulation());
        Assertions.assertEquals(1900, city.getFoundation());
    }

    @Test
    public void cityBuilderFieldTest(){
        Class<City> classCity = City.class;
        Class<CityBuilder> classCityBuilder = CityBuilder.class;

        Field[] fieldCity = classCity.getDeclaredFields();
        Field[] fieldCityBuilder = classCityBuilder.getDeclaredFields();

        Assertions.assertEquals(6,fieldCity.length);
        Assertions.assertEquals(fieldCityBuilder.length,fieldCity.length);
    }
}
