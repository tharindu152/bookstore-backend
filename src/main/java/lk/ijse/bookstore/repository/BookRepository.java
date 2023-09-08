package lk.ijse.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import lk.ijse.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT book FROM Book book WHERE book.subCategory.id = :subCategoryId") //SELECT * FROM items WHERE category_id = :categoryId
    List<Book> findBooksBySubCategoryId(@Param("subCategoryId") Long categoryId);

    @Query("SELECT book FROM Book book WHERE book.subCategory.category.id = :CategoryId") //SELECT * FROM books INNER JOIN subCategories ON books.id=subcategories WHERE category_id = :categoryId
    List<Book> findBooksByCategoryId(@Param("CategoryId") Long categoryId);

//     UPDATE customer SET name=?, address=?, salary=? WHERE id=?

// Eg- UPDATE customer SET name=’Kamal’, address=’Colombo’, salary=20000.00 WHERE id=1

}
