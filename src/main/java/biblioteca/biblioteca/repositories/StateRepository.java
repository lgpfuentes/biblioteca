package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
