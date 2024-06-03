package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDetailRepository extends JpaRepository<RentalDetailRepository, Long>{ 

}
