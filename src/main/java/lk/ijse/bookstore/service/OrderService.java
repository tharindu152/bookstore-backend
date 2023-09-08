package lk.ijse.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllorders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    List<Order> findOrderByUserId(Long userId);
}
