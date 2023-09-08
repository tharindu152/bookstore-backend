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
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.bookstore.entity.Order;
import lk.ijse.bookstore.service.OrderService;


@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController (OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllorders () {
        try{
            List<Order> orders = orderService.getAllorders();
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getorderById(@PathVariable Long id){
        
        try{
            Order order = orderService.getOrderById(id);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/orders")
    public ResponseEntity<Order> save(@RequestBody Order order){
        try{
            Order orderCreated = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(orderCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> update (@PathVariable long id, @RequestBody Order order){
        try{
            Order updatedorder = orderService.updateOrder(id, order);
            return ResponseEntity.status(HttpStatus.OK).body(updatedorder);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder (@PathVariable long id){
        try{
            orderService.deleteOrder(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }   
    }

    @GetMapping("/user/{userId}/orders")
    public ResponseEntity<List<Order>> getordersByUserId (@PathVariable Long userId) {
        try{
            List<Order> orders = orderService.findOrderByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }   
    }
}
