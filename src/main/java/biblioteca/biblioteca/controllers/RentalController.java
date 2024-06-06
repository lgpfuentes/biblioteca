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
import biblioteca.biblioteca.models.Rental;
import biblioteca.biblioteca.services.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping
    public void addRental(@RequestBody Rental rental) {
        rentalService.addRental(rental);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable("id") Long id) {
        rentalService.deleteRental(id);
    }

    @PutMapping("/{id}")
    public void updateRental(@PathVariable("id") Long id, @RequestBody Rental updatedRental) {
        rentalService.updateRental(id, updatedRental);
    }
}
