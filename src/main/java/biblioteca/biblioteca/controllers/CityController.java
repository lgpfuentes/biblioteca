package biblioteca.biblioteca.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import biblioteca.biblioteca.models.City;
import biblioteca.biblioteca.services.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.addCity(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public void updateCity(@PathVariable("id") Long id, @RequestBody City updatedCity) {
        cityService.updateCity(id, updatedCity);
    }
}
