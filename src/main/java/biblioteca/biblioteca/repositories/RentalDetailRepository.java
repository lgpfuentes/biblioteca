package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.RentalDetail;

@Repository
public interface RentalDetailRepository extends JpaRepository<RentalDetail, Long>{ 

}
