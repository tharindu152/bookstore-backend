package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Order;
import lk.ijse.bookstore.repository.OrderRepository;
import lk.ijse.bookstore.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }   

    @Override
    public List<Order> getAllorders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order ID " + id + " not found"));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);

        existingOrder.setUpdatedAt(order.getUpdatedAt());
        existingOrder.setStatus(order.getStatus());

        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
        } else{
            throw new NoSuchElementException("Order ID " + id + " not found");
        }
    }

    @Override
    public List<Order> findOrderByUserId(Long userId) {
        return orderRepository.findOrderByUserId(userId);
    }
    
}
