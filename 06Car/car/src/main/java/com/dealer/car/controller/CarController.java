package com.dealer.car.controller;

import com.dealer.car.model.Car;
import com.dealer.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/home")
    public String getCars(Model model, String keyword) {

        if (keyword != null) {//findByKeyWord
            model.addAttribute("cars", carService.findByKeyword(keyword));
        } else {
            model.addAttribute("cars", carService.getCars());
        }
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
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
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
