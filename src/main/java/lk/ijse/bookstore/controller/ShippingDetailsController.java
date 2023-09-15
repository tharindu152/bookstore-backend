package lk.ijse.bookstore.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.bookstore.entity.ShippingDetails;
import lk.ijse.bookstore.service.ShippingDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/shippingDetails")
public class ShippingDetailsController {

    private ShippingDetailsService shippingDetailsService;

    @Autowired
    public ShippingDetailsController (ShippingDetailsService shippingDetailsService){
        this.shippingDetailsService = shippingDetailsService;
    }

    @PostMapping
    public ResponseEntity<ShippingDetails> save(@RequestBody ShippingDetails shippingDetails){
        try{
            ShippingDetails shippingDetailsCreated = shippingDetailsService.createShippingDetails(shippingDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body(shippingDetailsCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingDetail (@PathVariable long id){
        try{
            shippingDetailsService.deleteShippingDetails(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } 
    }
    
}
