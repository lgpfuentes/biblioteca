package biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.models.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> { 

}
