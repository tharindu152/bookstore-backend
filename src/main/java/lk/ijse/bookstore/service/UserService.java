package lk.ijse.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.bookstore.dto.UserProfileDTO;
import lk.ijse.bookstore.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);
    User updateUser(Long id, UserProfileDTO user);
    void deleteUser(Long id);
}
