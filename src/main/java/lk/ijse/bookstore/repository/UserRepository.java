package lk.ijse.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import lk.ijse.bookstore.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User , Long>{

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    User getUserById(@Param("userId") Long userId);

}
