package com.sdargol.loader;

import com.sdargol.entity.City;
import com.sdargol.entity.CityBuilder;
import com.sdargol.util.DirectoryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
public class CityFileTextLoader implements ILoader<City> {
    @Value("${citybook.storage.source}")
    private String citiesFile;

    private List<City> mapper(List<String> src) {
        List<City> result = new ArrayList<>();

        for (String el : src) {
            String[] cityInfo = el.split(";");

            City city = new CityBuilder()
                    .setId(Integer.parseInt(cityInfo[0]))
                    .setName(cityInfo[1])
                    .setRegion(cityInfo[2])
                    .setDistrict(cityInfo[3])
                    .setPopulation(Integer.parseInt(cityInfo[4]))
                    .setFoundation(Short.parseShort(cityInfo[5]))
                    .build();

            result.add(city);
        }

        return result;
    }

    @Override
    public List<City> load() {
        String filePath = DirectoryUtil.getMainDir() + citiesFile;
        File cities = new File(filePath);
        List<String> data = new ArrayList<>();

        try {
            Scanner reader = new Scanner(cities);

            while (reader.hasNextLine()) {
                data.add(reader.nextLine());
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mapper(data);
    }
}
