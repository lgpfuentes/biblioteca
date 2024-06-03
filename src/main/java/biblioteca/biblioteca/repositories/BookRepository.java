package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
