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
import biblioteca.biblioteca.models.RentalDetail;
import biblioteca.biblioteca.services.RentalDetailService;

@RestController
@RequestMapping("/api/rental-details")
public class RentalDetailController {

    private final RentalDetailService rentalDetailService;

    public RentalDetailController(RentalDetailService rentalDetailService) {
        this.rentalDetailService = rentalDetailService;
    }

    @GetMapping
    public List<RentalDetail> getAllRentalDetails() {
        return rentalDetailService.getAllRentalDetails();
    }

    @PostMapping
    public void addRentalDetail(@RequestBody RentalDetail rentalDetail) {
        rentalDetailService.addRentalDetail(rentalDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteRentalDetail(@PathVariable("id") Long id) {
        rentalDetailService.deleteRentalDetail(id);
    }

    @PutMapping("/{id}")
    public void updateRentalDetail(@PathVariable("id") Long id, @RequestBody RentalDetail updatedRentalDetail) {
        rentalDetailService.updateRentalDetail(id, updatedRentalDetail);
    }
}
