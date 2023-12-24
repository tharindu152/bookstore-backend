package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.CategoryDTO;
import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.entity.SubCategory;
import lk.ijse.bookstore.service.BookService;
import lk.ijse.bookstore.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lk.ijse.bookstore.entity.Category;
import lk.ijse.bookstore.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/categories")
public class CategoryController {
    private CategoryService categoryService;
    private BookService bookService;
    private SubCategoryService subCategoryService;

    @Autowired
    public CategoryController (CategoryService categoryService, BookService bookService, SubCategoryService subCategoryService){
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.subCategoryService = subCategoryService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Category>> getAllCategories () {
        try{
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.status(HttpStatus.OK).body(categories);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        
        try{
            Category category = categoryService.getCategoryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> saveCategory(@RequestBody @Validated CategoryDTO categoryDTO){
        try{
            Category categoryCreated = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Category> updateCategory (@PathVariable long id, @RequestBody @Validated CategoryDTO categoryDTO){
        try{
            Category updatedCategory = categoryService.updateCategory(id, categoryDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory (@PathVariable long id){
        try{
            categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }   
    }

    @GetMapping(path = "/{catId}/books", produces = "application/json")
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

    @GetMapping(path = "/{catId}/subcategories", produces = "application/json")
    public ResponseEntity<List<SubCategory>> getSubCategoriesByCategoryId (@PathVariable Long catId) {
        try{
            List<SubCategory> subCategories = subCategoryService.getSubCategoriesByCategoryId(catId);
            System.out.println(subCategories);
            return ResponseEntity.status(HttpStatus.OK).body(subCategories);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
