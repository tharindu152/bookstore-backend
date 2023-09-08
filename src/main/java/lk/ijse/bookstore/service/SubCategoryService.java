package lk.ijse.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.SubCategory;

@Service
public interface SubCategoryService  {
    List<SubCategory> getAllSubCategories();
    SubCategory getSubCategoryById(Long id);
    SubCategory createSubCategory(SubCategory category);
    SubCategory updateSubCategory(Long id, SubCategory category);
    void deleteSubCategory(Long id);
    List<SubCategory> getSubCategoriesByCategoryId(Long categoryId);
}