package lk.ijse.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.bookstore.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>{

    @Query("SELECT s FROM SubCategory s WHERE s.category.id = :categoryId") //SELECT * FROM items WHERE category_id = :categoryId
    List<SubCategory> findSubCategoriesByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT s FROM SubCategory s WHERE s.id = :categoryId") //SELECT * FROM items WHERE category_id = :categoryId
    SubCategory findSubCategoriesBySubCategoryId(@Param("categoryId") Long categoryId);
    
}