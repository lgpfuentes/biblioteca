package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;


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

    public Rental updateRental(Long id, Rental updatedRental) {
        return rentalRepository.findById(id)
                .map(rental -> {
                    rental.setUser(updatedRental.getUser());
                    rental.setRentalDate(updatedRental.getRentalDate());
                    rental.setReturnDate(updatedRental.getReturnDate());
                    rental.setTotal(updatedRental.getTotal());
                    rental.setRentalDetails(updatedRental.getRentalDetails());
                    return rentalRepository.save(rental);
                })
                .orElseThrow(() -> new IllegalStateException("Rental with id " + id + " does not exist"));

    }

}
