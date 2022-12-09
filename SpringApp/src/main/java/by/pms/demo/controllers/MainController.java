package by.pms.demo.controllers;

import by.pms.demo.entity.Cars;
import by.pms.demo.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private CarsRepository carsRepository;

    @PostMapping(path = "/add")
    public String addNewCar(@RequestParam String car_make,
                            @RequestParam String car_model,
                            @RequestParam int car_year,
                            @RequestParam int expenses) {
        Cars car = new Cars(car_make, car_model, car_year, expenses);
        carsRepository.save(car);
        return "redirect:/home";
    }

    @GetMapping(path = "/home")
    public String getAll(Model model) {
        Iterable<Cars> car = carsRepository.findAll();
        model.addAttribute("car", car);
        return "home";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        carsRepository.deleteById(id);
        return "redirect:/home";
    }

    @PostMapping(path = "/update")
    public String update(@RequestParam Long id,
                         @RequestParam String car_make,
                         @RequestParam String car_model,
                         @RequestParam int car_year,
                         @RequestParam int expenses) {
        try {
            Optional<Cars> c = carsRepository.findById(id);
            c.get().setCar_make(car_make);
            c.get().setCar_model(car_model);
            c.get().setCar_year(car_year);
            c.get().setExpenses(expenses);
            carsRepository.save(c.get());
        } catch (Exception e){
            return "redirect:/home";
        }
        return "redirect:/home";
    }
}