package com.example.week67.controllers;

import com.example.week67.models.Car;
import com.example.week67.service.CarsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CarsController {
    private final CarsServices carsServices;


    @GetMapping("/")
    public String cars(@RequestParam(name = "title",required = false) String title, Model model) {
//        model.addAllAttributes("cars", carsServices.listCar(title));
        return "cars";
    }

    @GetMapping("/product/{id}")
    public String carInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", carsServices.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createCar(Car car) {
        carsServices.saveProduct(car);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carsServices.deleteCar(id);
        return "redirect:/";
    }
}
