package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.repository.BookRepository;
import lk.ijse.bookstore.service.BookService;


@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book ID " + id + " not found"));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook= getBookById(id);

        existingBook.setQuantity(book.getQuantity());
        existingBook.setFeatured(book.isFeatured());
        existingBook.setCoverImage(book.getCoverImage());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Book ID " + id + " not found");
        } 
    }

    @Override
    public List<Book> getBooksByCategoryId(Long categoryId) {
        return bookRepository.findBooksByCategoryId(categoryId);
    }
    
    @Override
    public List<Book> getBooksBySubCategoryId(Long subCategoryId) {
        return bookRepository.findBooksBySubCategoryId(subCategoryId);
    }

}
