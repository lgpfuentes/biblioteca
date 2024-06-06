package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.RentalDetail;
import biblioteca.biblioteca.repositories.RentalDetailRepository;

@Service
public class RentalDetailService {

    private final RentalDetailRepository rentalDetailRepository;

    public RentalDetailService(RentalDetailRepository rentalDetailRepository) {
        this.rentalDetailRepository = rentalDetailRepository;
    }

    public List<RentalDetail> getAllRentalDetails() {
        return rentalDetailRepository.findAll();
    }

    public Optional<RentalDetail> getRentalDetailById(Long id) {
        return rentalDetailRepository.findById(id);
    }

    public RentalDetail addRentalDetail(RentalDetail rentalDetail) {
        return rentalDetailRepository.save(rentalDetail);
    }

    public void deleteRentalDetail(Long id) {
        boolean rentalDetailExists = rentalDetailRepository.existsById(id);
        if (!rentalDetailExists) {
            throw new IllegalStateException("RentalDetail with id " + id + " does not exist");
        }
        rentalDetailRepository.deleteById(id);
    }

    public RentalDetail updateRentalDetail(Long id, RentalDetail updatedRentalDetail) {
        return rentalDetailRepository.findById(id)
                .map(rentalDetail -> {
                    rentalDetail.setRental(updatedRentalDetail.getRental());
                    rentalDetail.setBook(updatedRentalDetail.getBook());
                    rentalDetail.setSubtotal(updatedRentalDetail.getSubtotal());
                    return rentalDetailRepository.save(rentalDetail);
                })
                .orElseThrow(() -> new IllegalStateException("Rental detail with id " + id + " does not exist"));
    }

}
