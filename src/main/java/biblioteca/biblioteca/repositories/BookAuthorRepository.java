package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.BookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

}
