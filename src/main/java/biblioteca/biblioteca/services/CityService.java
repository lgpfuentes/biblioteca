package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.City;
import biblioteca.biblioteca.repositories.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        boolean cityExists = cityRepository.existsById(id);
        if (!cityExists) {
            throw new IllegalStateException("City with id " + id + " does not exist");
        }
        cityRepository.deleteById(id);
    }

    public City updateCity(Long id, City newCityData) {
        return cityRepository.findById(id)
                .map(city -> {
                    city.setName(newCityData.getName());
                    city.setState(newCityData.getState());
                    return cityRepository.save(city);
                })
                .orElseThrow(() -> new IllegalStateException("City with id " + id + " does not exist"));
    }

}
