package biblioteca.biblioteca.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biblioteca.biblioteca.models.Book;
import biblioteca.biblioteca.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public void getAllBooks() {
        List<Book> books = bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
    }
}
