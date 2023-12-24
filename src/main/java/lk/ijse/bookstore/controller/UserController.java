package lk.ijse.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.UserDTO;
import lk.ijse.bookstore.entity.Order;
import lk.ijse.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lk.ijse.bookstore.entity.User;
import lk.ijse.bookstore.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/users")
public class UserController {
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public UserController (UserService userService, OrderService orderService){
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers(){
        
        try{
            List<User> users = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        try{
            User user = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

     @PostMapping(produces = "application/json", consumes = "application/json")
     public ResponseEntity<User> saveUser(@RequestBody @Validated UserDTO userDTO){
         try{
             User userCreated = userService.saveUser(userDTO);
             return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
         }catch(Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
     }

     @PatchMapping(path = "/{id}", consumes = "application/json")
     public ResponseEntity<User> updateUser (@PathVariable long id, @RequestBody @Validated UserDTO userDTO){
         try{
             User updatedUser = userService.updateUser(id, userDTO);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
         } catch (NoSuchElementException e){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
         } catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
     }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }   
    }

    @GetMapping(path = "/{userId}/orders")
    public ResponseEntity<List<Order>> getOrdersByUserId (@PathVariable Long userId) {
        try{
            List<Order> orders = orderService.getOrderByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
