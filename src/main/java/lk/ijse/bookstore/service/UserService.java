package lk.ijse.bookstore.service;

import java.util.List;

import lk.ijse.bookstore.dto.UserDTO;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(UserDTO userDTO);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
