package lk.ijse.bookstore.service;

import java.util.List;

import lk.ijse.bookstore.dto.OrderDTO;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderDTO orderDTO);
    Order updateOrder(Long id, OrderDTO orderDTO);
    void deleteOrder(Long id);
    List<Order> getOrderByUserId(Long userId);
}
