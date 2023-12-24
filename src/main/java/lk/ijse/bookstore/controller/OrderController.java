package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lk.ijse.bookstore.entity.Order;
import lk.ijse.bookstore.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController (OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Order>> getAllOrders () {
        try{
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        try{
            Order order = orderService.getOrderById(id);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Order> saveOrder(@RequestBody @Validated OrderDTO orderDTO){
        try{
            Order orderCreated = orderService.createOrder(orderDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(orderCreated);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Order> updateOrder (@PathVariable long id, @RequestBody @Validated OrderDTO orderDTO){
        try{
            Order updatedorder = orderService.updateOrder(id, orderDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder (@PathVariable long id){
        try{
            orderService.deleteOrder(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
