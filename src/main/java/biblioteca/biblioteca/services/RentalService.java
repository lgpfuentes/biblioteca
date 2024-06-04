package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.Rental;
import biblioteca.biblioteca.repositories.RentalRepository;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRentalById(Long id) {
        return rentalRepository.findById(id);
    }

    public Rental addRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        boolean rentalExists = rentalRepository.existsById(id);
        if (!rentalExists) {
            throw new IllegalStateException("Rental with id " + id + " does not exist");
        }
        rentalRepository.deleteById(id);
    }

}
