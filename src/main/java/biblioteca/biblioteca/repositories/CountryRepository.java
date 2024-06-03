package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
