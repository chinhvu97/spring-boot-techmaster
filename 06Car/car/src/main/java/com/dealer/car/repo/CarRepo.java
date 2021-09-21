package com.dealer.car.repo;

import com.dealer.car.model.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepo {
    private List<Car> cars = new ArrayList<>();
    public CarRepo() {
        try {
            File file = ResourceUtils.getFile("classpath:static/car-data.json");
            ObjectMapper mapper = new ObjectMapper();
            cars.addAll(mapper.readValue(file, new TypeReference<List<Car>>(){}));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Car> getCars() {
        return cars;
    }

    public Car findById(Integer id) {
        return cars.stream().filter(car -> car.getId() == id)
                .findAny().orElse(null);
    }

    public List<Car> findByKeyWord(String keyword) {
        return cars.stream().filter(car -> (StringUtils.containsIgnoreCase(car.getManufacturer(), keyword) ||
                        StringUtils.containsIgnoreCase(car.getModel(), keyword)))
                .collect(Collectors.toList());
    }

    public void addCar(Car newCar) {
        cars.add(newCar);
    }

    public void save(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == car.getId()) {
                cars.set(i, car);
            }
        }
    }

    public void delete(Car car) {
        cars.remove(car);
    }
}
