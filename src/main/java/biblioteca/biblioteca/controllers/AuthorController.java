package biblioteca.biblioteca.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biblioteca.biblioteca.models.Author;
import biblioteca.biblioteca.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author updatedAuthor) {
        Author author = authorService.updateAuthor(id, updatedAuthor);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
