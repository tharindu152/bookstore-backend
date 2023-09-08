package lk.ijse.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.bookstore.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>{

    @Query("SELECT subCategory FROM SubCategory subCategory WHERE subCategory.category.id = :CategoryId") //SELECT * FROM items WHERE category_id = :categoryId
    List<SubCategory> findSubCategoriesByCategoryId(@Param("CategoryId") Long categoryId);
    
}