package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.SubCategoryDTO;
import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lk.ijse.bookstore.entity.SubCategory;
import lk.ijse.bookstore.service.SubCategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/subcategories")
public class SubCategoryController {

    private SubCategoryService subcategoryService;
    private BookService bookService;

    @Autowired
    public SubCategoryController ( SubCategoryService subcategoryService, BookService bookService){
        this.subcategoryService = subcategoryService;
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SubCategory>> getAllSubCategories () {
        try{
            List<SubCategory> subcategories = subcategoryService.getAllSubCategories();
            return ResponseEntity.status(HttpStatus.OK).body(subcategories);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long id){
        try{
            SubCategory subcategory = subcategoryService.getSubCategoryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(subcategory);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<SubCategory> saveSubcategory(@RequestBody @Validated SubCategoryDTO subCategoryDTO){
        try{
            SubCategory subcategoryCreated = subcategoryService.createSubCategory(subCategoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(subcategoryCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<SubCategory> updateSubCategory (@PathVariable long id, @RequestBody @Validated SubCategoryDTO subCategoryDTO){
        try{
            SubCategory updatedSubCategory = subcategoryService.updateSubCategory(id, subCategoryDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory (@PathVariable long id){
        try{
            subcategoryService.deleteSubCategory(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } 
    }

    @GetMapping(path = "/{catId}/books", produces = "application/json")
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

}
