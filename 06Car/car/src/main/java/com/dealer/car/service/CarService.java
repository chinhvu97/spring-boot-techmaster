package com.dealer.car.service;

import com.dealer.car.exception.UserNotFoundException;
import com.dealer.car.model.Car;
import com.dealer.car.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;
    public List<Car> getCars() {
        return carRepo.getCars();
    }

    public Car findById(Integer id) {
        Car car = carRepo.findById(id);
        if (car==null) {
            throw new UserNotFoundException("user by id " + id + " not found");
        }
        return car;
    }

    public List<Car> findByKeyword(String keyword) {
        return carRepo.findByKeyWord(keyword);
    }

    public void addCar(Car newCar) {
        carRepo.addCar(newCar);
    }


    public void save(Car car) {
        carRepo.save(car);
    }

    public void delete(Car car) {
        carRepo.delete(car);
    }
}
