package com.sdargol.service;

import com.sdargol.DTO.CountCityInRegionDTO;
import com.sdargol.entity.City;
import com.sdargol.loader.ILoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CityBookService implements ICityBookService {
    private final ILoader<City> loader;
    private final Function<Comparator<City>, List<City>> loadSortCities;

    @Autowired
    public CityBookService(ILoader<City> loader) {
        this.loader = loader;

        loadSortCities = (comparator) -> loader.load()
                .stream()
                .sorted(comparator)
                .toList();
    }

    @Override
    public List<City> getAll() {
        return loader.load();
    }

    @Override
    public List<City> getAllSortByAlphabet() {
        Comparator<City> comparator = (a, b) -> a.getName().compareToIgnoreCase(b.getName());

        /*return loader.load()
                .stream()
                .sorted(comparator)
                .toList(); */

        return loadSortCities.apply(comparator);
    }

    @Override
    public List<City> getAllSortByDistrictAndName() {
        Comparator<City> comparator = Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName);

        /*return loader.load()
                .stream()
                .sorted(comparator)
                .toList();*/

        return loadSortCities.apply(comparator);
    }

    @Override
    public Optional<City> searchCityMaxPopulation() {
        Comparator<City> comparator = Comparator.comparingInt(City::getPopulation);

        return loader.load().stream().max(comparator);
    }

    @Override
    public List<CountCityInRegionDTO> getCountCityInRegion() {
        /*BiConsumer<HashMap<String, Integer>, City> accumulator = (map, city) -> {
            if(map.containsKey(city.getDistrict())){
                System.out.println("работает");
                Integer tmp = map.get(city.getDistrict());
                tmp = tmp + 1;
                map.put(city.getDistrict(), tmp);
                return;
            }
            map.put(city.getDistrict(), 1);
        };*/

        HashMap<String, Integer> stats = loader.load()
                .stream()
                .collect(
                        HashMap::new,
                        (map, city) -> map.merge(city.getRegion(), 1, Integer::sum),
                        HashMap::putAll
                );

        return countCityInRegionMapper(stats);

        /*return loader.load().stream().collect(
                HashMap::new,
                accumulator,
                HashMap::putAll
        );*/
    }

    private List<CountCityInRegionDTO> countCityInRegionMapper(HashMap<String, Integer> map){
        return map.entrySet()
                .stream()
                .map(e -> new CountCityInRegionDTO(e.getValue(), e.getKey()))
                .toList();
    }
}
