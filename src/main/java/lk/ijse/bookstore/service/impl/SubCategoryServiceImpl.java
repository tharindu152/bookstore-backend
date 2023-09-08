package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.SubCategory;
import lk.ijse.bookstore.repository.SubCategoryRepository;
import lk.ijse.bookstore.service.SubCategoryService;


@Service
public class SubCategoryServiceImpl implements SubCategoryService{
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl (SubCategoryRepository subCategoryRepository){
        this.subCategoryRepository = subCategoryRepository;
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
    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory updateSubCategory(Long id, SubCategory subCategory) {
        SubCategory existingSubCategory= getSubCategoryById(id);

        existingSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
        existingSubCategory.setDescription(subCategory.getDescription());

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
