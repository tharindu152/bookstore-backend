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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.bookstore.dto.UserProfileDTO;
import lk.ijse.bookstore.entity.User;
import lk.ijse.bookstore.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
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

    @GetMapping("/{id}")
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

    // @PostMapping
    // public ResponseEntity<User> save(@RequestBody User user){
    //     try{
    //         User userCreated = userService.saveUser(user);
    //         return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    //     }catch(Exception e){
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    //     }
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<User> update (@PathVariable long id, @RequestBody User user){
    //     try{
    //         User updatedUser = userService.updateUser(id, user);
    //         return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    //     } catch (NoSuchElementException e){
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
    //     } catch (Exception e){
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    //     }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }   
    }

    @PostMapping("/user/{id}/profile")
    public ResponseEntity<User> updateProfile(@PathVariable Long id, @ModelAttribute UserProfileDTO userProfileDTO) {
        return new ResponseEntity<User>(userService.updateUser(id, userProfileDTO), HttpStatus.OK);
    }
}
