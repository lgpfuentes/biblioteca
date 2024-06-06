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
import biblioteca.biblioteca.models.Category;
import biblioteca.biblioteca.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable("id") Long id, @RequestBody Category updatedCategory) {
        categoryService.updateCategory(id, updatedCategory);
    }
}
