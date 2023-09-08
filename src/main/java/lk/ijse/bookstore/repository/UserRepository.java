package lk.ijse.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.bookstore.entity.User;


public interface UserRepository extends JpaRepository<User , Long>{
    //Custom queries
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
