package lk.ijse.bookstore.service;

import java.util.List;

import lk.ijse.bookstore.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Category;

@Service
public interface CategoryService  {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
