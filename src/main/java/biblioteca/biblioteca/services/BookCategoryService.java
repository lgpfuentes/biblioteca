package biblioteca.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.BookCategory;
import biblioteca.biblioteca.repositories.BookCategoryRepository;

@Service
public class BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    public BookCategory addBookCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    public void deleteBookCategory(Long id) {

        boolean bookCategoryExists = bookCategoryRepository.existsById(id);

        if (!bookCategoryExists) {
            throw new IllegalStateException("Register with id " + id + " does not exist");
        }

        bookCategoryRepository.deleteById(id);
    }

    public BookCategory updateBookCategory(Long id, BookCategory updatedBookCategory) {
        return bookCategoryRepository.findById(id).map(bookCategory -> {
            bookCategory.setBook(updatedBookCategory.getBook());
            bookCategory.setCategory(updatedBookCategory.getCategory());
            return bookCategoryRepository.save(bookCategory);
        }).orElseThrow(() -> new IllegalStateException("BookCategory with id " + id + " does not exist"));
    }
}
