package biblioteca.biblioteca.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import biblioteca.biblioteca.models.BookAuthor;
import biblioteca.biblioteca.services.BookAuthorService;

@RestController
@RequestMapping("/bookauthors")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping
    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    @PostMapping
    public void addBookAuthor(@RequestBody BookAuthor bookAuthor) {
        bookAuthorService.addBookAuthor(bookAuthor);
    }

    @DeleteMapping("/{id}")
    public void deleteBookAuthor(@PathVariable("id") Long id) {
        bookAuthorService.deleteBookAuthor(id);
    }

    @PutMapping("/{id}")
    public void updateBookAuthor(@PathVariable("id") Long id, @RequestBody BookAuthor updatedBookAuthor) {
        bookAuthorService.updateBookAuthor(id, updatedBookAuthor);
    }
}
