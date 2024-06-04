package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.Country;
import biblioteca.biblioteca.repositories.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        boolean countryExists = countryRepository.existsById(id);
        if (!countryExists) {
            throw new IllegalStateException("Country with id " + id + " does not exist");
        }
        countryRepository.deleteById(id);
    }

}
