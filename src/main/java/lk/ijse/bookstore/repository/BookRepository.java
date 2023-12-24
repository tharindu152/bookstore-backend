package lk.ijse.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import lk.ijse.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.subCategory.id = :subCategoryId") //SELECT * FROM book WHERE category_id = :categoryId
    List<Book> findBooksBySubCategoryId(@Param("subCategoryId") Long subCategoryId);

    @Query("SELECT b FROM Book b WHERE b.subCategory.category.id = :categoryId") //SELECT * FROM books INNER JOIN subCategories ON books.id=subcategories WHERE category_id = :categoryId
    List<Book> findBooksByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT b FROM Book b WHERE b.id = :bookId")
    Book findBookById(@Param("bookId") Long bookId);


}
