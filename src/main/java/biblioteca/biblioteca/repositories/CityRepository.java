package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
