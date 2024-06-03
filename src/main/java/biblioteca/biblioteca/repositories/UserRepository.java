package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
