package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.Category;
import biblioteca.biblioteca.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        boolean categoryExists = categoryRepository.existsById(id);
        if (!categoryExists) {
            throw new IllegalStateException("Category with id " + id + " does not exist");
        }
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Long id, Category newCategoryData) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategoryData.getName());
                    category.setBooks(newCategoryData.getBooks());
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist"));
    }

}
