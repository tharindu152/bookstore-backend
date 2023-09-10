package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.bookstore.dto.BookCreateDTO;
import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.service.BookService;


@CrossOrigin(origins = "*")
@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks () {
        try{
            List<Book> books = bookService.getAllBooks();
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }    
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        
        try{
            Book book = bookService.getBookById(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/books")
    public ResponseEntity<Book> save(@RequestBody Book book){
        try{
            System.out.println(book);
            Book bookCreated = bookService.createBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update (@PathVariable long id, @RequestBody Book book){
        try{
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/bookCoverImage/{id}")
    public ResponseEntity<Book> updateBookCoverImage(@PathVariable Long id, @ModelAttribute BookCreateDTO bookCreateDTO) {
        try{
            return new ResponseEntity<Book>(bookService.updateBookCoverImage(id, bookCreateDTO), HttpStatus.OK);
        }catch(NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable long id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

    @GetMapping("/subcategories/{catId}/books")
    public ResponseEntity<List<Book>> getBooksBySubCategoryId (@PathVariable Long catId) {
        try{
            List<Book> books = bookService.getBooksBySubCategoryId(catId);
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

    @GetMapping("/categories/{catId}/books")
    public ResponseEntity<List<Book>> getBooksByCategoryId (@PathVariable Long catId) {
        try{
            List<Book> books = bookService.getBooksByCategoryId(catId);
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

    
}
