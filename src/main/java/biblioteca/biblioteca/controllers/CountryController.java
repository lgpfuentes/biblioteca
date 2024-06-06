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
import biblioteca.biblioteca.models.Country;
import biblioteca.biblioteca.services.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountry(id);
    }

    @PutMapping("/{id}")
    public void updateCountry(@PathVariable("id") Long id, @RequestBody Country updatedCountry) {
        countryService.updateCountry(id, updatedCountry);
    }
}
