package com.dealer.car.controller;

import com.dealer.car.model.Car;
import com.dealer.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping()
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/home")
    public String getCars(Model model, String keyword, String sortByPriceASC, String sortByPriceDESC) {
        List<Car> cars;

        if (keyword != null) {//findByKeyWord
            cars = carService.findByKeyword(keyword);
        } else {
            cars = carService.getCars();
        }

        if (sortByPriceASC != null && cars != null) {
            cars.sort(Comparator.comparing(Car::getPrice));
        } else if (sortByPriceDESC != null && cars != null) {
            cars.sort(Comparator.comparing(Car::getPrice).reversed());
        }
        model.addAttribute("cars", cars);
        return "home";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        Car newCar = new Car();
        model.addAttribute("newCar", newCar);
        return "add";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute("newCar") Car newCar) {
        carService.addCar(newCar);
        return "redirect:home";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable ("id") Integer id,
                                 Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable("id") Integer id,
                            Car car,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //edit again
            car.setId(id);
            return "update";
        }
        carService.save(car);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id, Model model) {
        Car car = carService.findById(id);
        System.out.println("Delete car: " + car);
        carService.delete(car);
        return "redirect:/home";
    }
}
