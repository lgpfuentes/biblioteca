package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.Book;
import biblioteca.biblioteca.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        Optional<Book> bookIsPresent = bookRepository.findByIsbn(book.getIsbn());

        if (bookIsPresent.isPresent()) {
            throw new IllegalStateException("Book with isbn " + book.getIsbn() + " already exists");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        boolean bookExists = bookRepository.existsById(id);

        if (!bookExists) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }

        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setIsbn(updatedBook.getIsbn());
            book.setTitle(updatedBook.getTitle());
            book.setPublishYear(updatedBook.getPublishYear());
            book.setAuthors(updatedBook.getAuthors());
            book.setCategories(updatedBook.getCategories());
            return bookRepository.save(book);
        }).orElseThrow(() -> new IllegalStateException("Book with id " + id + " does not exist"));
    }

}
