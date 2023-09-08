package lk.ijse.bookstore.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lk.ijse.bookstore.dto.UserProfileDTO;
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

    @Value("${upload.directory}")
    private String uploadDirectory;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User ID " + id + " not found"));
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    // @Override
    // public User updateUser(Long id, User user) {
    //     User existingUser = getUserById(id);

    //     existingUser.setUsername(user.getUsername());
    //     existingUser.setEmail(user.getEmail());
    //     existingUser.setPassword(user.getPassword());
    //     existingUser.setProfileImage(user.getProfileImage());

    //     return userRepository.save(existingUser);
    // } 
       

    @Override 
    public User updateUser(Long id, UserProfileDTO userProfileDTO) {
        User existingUser = userRepository.findById(id).orElse(null);

        if(existingUser != null) {
            
            MultipartFile file = userProfileDTO.getProfileImage();
            String filename = file.getOriginalFilename();
            String filePath = uploadDirectory + File.separator + filename;

            try {
                file.transferTo(new File(filePath));
            } catch (IllegalStateException e) {
                
                e.printStackTrace();
            } catch (IOException e) {
                
                e.printStackTrace();
            }

            existingUser.setProfileImage(filename);
            return userRepository.save(existingUser);
        }

        return null;
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
