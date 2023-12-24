package lk.ijse.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.bookstore.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("SELECT c FROM Category c WHERE c.id = :catId")
    Category getCategoryBySubCategoryId(@Param("catId") Long catId);

}
