package com.example.week8.controllers;

import com.example.week8.entity.Cars;
import com.example.week8.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CarRepo carRepo;

    @GetMapping("/")
    public String greeting(String name, Map<String, Object>model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Cars> car = carRepo.findAll();
        model.put("lists", car);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Cars cars = new Cars(text, tag);
        carRepo.save(cars);
        Iterable<Cars> car = carRepo.findAll();
        model.put("lists", car);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Cars> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = carRepo.findByTag(filter);
        } else {
            messages = carRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

    @RestController
    public class IndexController implements ErrorController {

        private static final String PATH = "/error";

        @RequestMapping(value = PATH)
        public String error() {
            return "Error handling";
        }

        public String getErrorPath() {
            return PATH;
        }
    }
}