package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.SubCategoryDTO;
import lk.ijse.bookstore.entity.Category;
import lk.ijse.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.SubCategory;
import lk.ijse.bookstore.repository.SubCategoryRepository;
import lk.ijse.bookstore.service.SubCategoryService;


@Service
public class SubCategoryServiceImpl implements SubCategoryService{
    private SubCategoryRepository subCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SubCategoryServiceImpl (SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository){
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("SubCategory ID " + id + " not found"));
    }

    @Override
    public SubCategory createSubCategory(SubCategoryDTO subCategoryDTO) {
        Category category = categoryRepository.getCategoryBySubCategoryId(Long.valueOf(subCategoryDTO.getCategoryId()));
        if(category != null){
            SubCategory subCategory = new SubCategory( subCategoryDTO.getSubCatName(), subCategoryDTO.getDescription(), category);
            return subCategoryRepository.save(subCategory);
        }else {
            throw new NoSuchElementException("Category ID: " + subCategoryDTO.getCategoryId() + " not found");
        }
    }

    @Override
    public SubCategory updateSubCategory(Long id, SubCategoryDTO subCategoryDTO) {
        SubCategory existingSubCategory;

        if(subCategoryRepository.existsById(id)){
            existingSubCategory= getSubCategoryById(id);

            existingSubCategory.setSubCatName(subCategoryDTO.getSubCatName());
            existingSubCategory.setDescription(subCategoryDTO.getDescription());
        }else{
            throw new NoSuchElementException("SubCategory ID: " + id + " not found");
        }

        return subCategoryRepository.save(existingSubCategory);
    }

    @Override
    public void deleteSubCategory(Long id) {
        if(subCategoryRepository.existsById(id)){
            subCategoryRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("SubCategory ID " + id + " not found");
        } 
    }

    @Override
    public List<SubCategory> getSubCategoriesByCategoryId(Long categoryId) {
        return subCategoryRepository.findSubCategoriesByCategoryId(categoryId);
    }
}
