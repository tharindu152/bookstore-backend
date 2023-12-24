package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lk.ijse.bookstore.dto.BookDTO;
import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.service.BookService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
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

    @GetMapping(path = "/{id}", produces = "application/json")
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

    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Book> saveBook(@ModelAttribute @Validated BookDTO bookDTO){
        try{
            Book bookCreated = bookService.createBook(bookDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping(path = "/{bookId}", consumes = "multipart/form-data")
    public ResponseEntity<Book> updateBook (@PathVariable long bookId, @ModelAttribute @Validated BookDTO bookDTO){
        try{
            System.out.println(bookId);
            Book updatedBook = bookService.updateBook(bookId, bookDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

//    @GetMapping(produces = "application/json", params = "query")
//    public ResponseEntity<List<Book>> getBooksByQuery(String query){
//        try{
//            System.out.println(query);
//            List<Book> booksByQuery = bookService.getBooksByQuery(query);
//            return ResponseEntity.status(HttpStatus.OK).body(booksByQuery);
//        } catch (NoSuchElementException e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }

    
}
