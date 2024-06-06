package biblioteca.biblioteca.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import biblioteca.biblioteca.models.BookCategory;
import biblioteca.biblioteca.services.BookCategoryService;

@RestController
@RequestMapping("/api/bookCategories")
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;

    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    public List<BookCategory> getAllBookCategories() {
        return bookCategoryService.getAllBookCategories();
    }

    @PostMapping
    public void addBookCategory(@RequestBody BookCategory bookCategory) {
        bookCategoryService.addBookCategory(bookCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteBookCategory(@PathVariable("id") Long id) {
        bookCategoryService.deleteBookCategory(id);
    }

    @PutMapping("/{id}")
    public void updateBookCategory(@PathVariable("id") Long id, @RequestBody BookCategory updatedBookCategory) {
        bookCategoryService.updateBookCategory(id, updatedBookCategory);
    }
}
