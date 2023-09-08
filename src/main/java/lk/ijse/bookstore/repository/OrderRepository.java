package lk.ijse.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.bookstore.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT order FROM Order order WHERE order.user.id = :userId")
    List<Order> findOrderByUserId(@Param("userId") Long userId);    
}
