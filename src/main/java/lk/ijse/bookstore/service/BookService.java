package lk.ijse.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.bookstore.dto.BookCreateDTO;
import lk.ijse.bookstore.entity.Book;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book) throws Exception;
    Book updateBook(Long id, Book book);
    Book updateBookCoverImage(Long id, BookCreateDTO bookCreateDTO);
    void deleteBook(Long id);
    List<Book> getBooksByCategoryId(Long categoryId);
    List<Book> getBooksBySubCategoryId(Long subCategoryId);
    
}
