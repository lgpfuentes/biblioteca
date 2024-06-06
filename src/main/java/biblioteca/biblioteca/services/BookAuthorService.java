package biblioteca.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.BookAuthor;
import biblioteca.biblioteca.repositories.BookAuthorRepository;

@Service
public class BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorRepository.findAll();
    }

    public BookAuthor addBookAuthor(BookAuthor bookAuthor) {
        return bookAuthorRepository.save(bookAuthor);
    }

    public void deleteBookAuthor(Long id) {

        boolean bookAuthorExists = bookAuthorRepository.existsById(id);

        if (!bookAuthorExists) {
            throw new IllegalStateException("Register with id " + id + " does not exist");
        }

        bookAuthorRepository.deleteById(id);
    }

    public BookAuthor updateBookAuthor(Long id, BookAuthor updatedBookAuthor) {
        return bookAuthorRepository.findById(id).map(bookAuthor -> {
            bookAuthor.setBook(updatedBookAuthor.getBook());
            bookAuthor.setAuthor(updatedBookAuthor.getAuthor());
            return bookAuthorRepository.save(bookAuthor);
        }).orElseThrow(() -> new IllegalStateException("BookAuthor with id " + id + " does not exist"));
    }

}
