package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import lk.ijse.bookstore.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.User;
import lk.ijse.bookstore.repository.UserRepository;
import lk.ijse.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User ID " + id + " not found"));
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getCountry(), userDTO.getStreet(), userDTO.getCity(),
                userDTO.getState(), userDTO.getZipCode(), userDTO.getMobileNumber(), userDTO.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User existingUser;
        if(userRepository.existsById(id)){
            existingUser = getUserById(id);

            existingUser.setName(userDTO.getName());
            existingUser.setCountry(userDTO.getCountry());
            existingUser.setStreet(userDTO.getStreet());
            existingUser.setCity(userDTO.getCity());
            existingUser.setState(userDTO.getState());
            existingUser.setZipCode(userDTO.getZipCode());
            existingUser.setMobileNumber(userDTO.getMobileNumber());
            existingUser.setEmail(userDTO.getMobileNumber());
        }else{
            throw new NoSuchElementException("User ID: " + id + " not found");
        }
        return userRepository.save(existingUser);
    } 
    

    @Override
    public void deleteUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("User ID " + id + " not found");
        }   
    }   
}
