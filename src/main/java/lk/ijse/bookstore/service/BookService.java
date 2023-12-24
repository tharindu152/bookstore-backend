package lk.ijse.bookstore.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.bookstore.dto.BookDTO;
import lk.ijse.bookstore.entity.Book;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(BookDTO bookReqDTO) throws Exception;
    Book updateBook(Long id, BookDTO bookReqDTO) throws IOException;
    void deleteBook(Long id);
    List<Book> getBooksByCategoryId(Long categoryId);
    List<Book> getBooksBySubCategoryId(Long subCategoryId);
//    List<Book> getBooksByQuery(String query);
    
}
