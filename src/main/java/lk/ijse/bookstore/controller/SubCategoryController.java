package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.bookstore.entity.SubCategory;
import lk.ijse.bookstore.service.SubCategoryService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {
    private SubCategoryService subcategoryService;

    @Autowired
    public SubCategoryController (SubCategoryService subcategoryService){
        this.subcategoryService = subcategoryService;
    }

    @GetMapping
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

    @GetMapping("/{id}")
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

    @PostMapping
    public ResponseEntity<SubCategory> save(@RequestBody SubCategory subcategory){
        try{
            SubCategory subcategoryCreated = subcategoryService.createSubCategory(subcategory);
            return ResponseEntity.status(HttpStatus.CREATED).body(subcategoryCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> update (@PathVariable long id, @RequestBody SubCategory subcategory){
        try{
            SubCategory updatedSubCategory = subcategoryService.updateSubCategory(id, subcategory);
            return ResponseEntity.status(HttpStatus.OK).body(updatedSubCategory);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable long id){
        try{
            subcategoryService.deleteSubCategory(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } 
    }


    @GetMapping("/categories/{catId}/subcategories")
    public ResponseEntity<List<SubCategory>> getSubCategoriesByCategoryId (@PathVariable Long catId) {
        try{
            List<SubCategory> subCategories = subcategoryService.getSubCategoriesByCategoryId(catId);
            System.out.println(subCategories);
            return ResponseEntity.status(HttpStatus.OK).body(subCategories);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

}
