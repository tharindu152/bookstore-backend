package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Category;
import lk.ijse.bookstore.repository.CategoryRepository;
import lk.ijse.bookstore.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Category ID " + id + " not found"));
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getCatName(), categoryDTO.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategory;

        if(categoryRepository.existsById(id)){
            existingCategory= getCategoryById(id);

            existingCategory.setCatName(categoryDTO.getCatName());
            existingCategory.setDescription(categoryDTO.getDescription());
        }else{
            throw new NoSuchElementException("Category ID " + id + " not found");
        }

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Category ID " + id + " not found");
        } 
    }
}
