package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {
    private final CarService carServiceImpl;

    public CarsController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(defaultValue = "5") int count,
                               ModelMap model) {
        model.addAttribute("listCars", carServiceImpl.getListCars(count));
        return "cars/cars";
    }

}