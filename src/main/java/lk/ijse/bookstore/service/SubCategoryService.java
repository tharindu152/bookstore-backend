package lk.ijse.bookstore.service;

import java.util.List;

import lk.ijse.bookstore.dto.SubCategoryDTO;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.SubCategory;

@Service
public interface SubCategoryService  {
    List<SubCategory> getAllSubCategories();
    SubCategory getSubCategoryById(Long id);
    SubCategory createSubCategory(SubCategoryDTO subCategoryDTO);
    SubCategory updateSubCategory(Long id, SubCategoryDTO subCategoryDTO);
    void deleteSubCategory(Long id);
    List<SubCategory> getSubCategoriesByCategoryId(Long categoryId);
}