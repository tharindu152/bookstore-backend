package lk.ijse.bookstore.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import lk.ijse.bookstore.dto.OrderDTO;
import lk.ijse.bookstore.entity.Book;
import lk.ijse.bookstore.entity.User;
import lk.ijse.bookstore.repository.BookRepository;
import lk.ijse.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.Order;
import lk.ijse.bookstore.repository.OrderRepository;
import lk.ijse.bookstore.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;

    private BookRepository bookRepository;

    @Autowired
    public OrderServiceImpl (OrderRepository orderRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }   

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order ID " + id + " not found"));
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        User user = userRepository.getUserById(Long.valueOf(orderDTO.getUserId()));

        Set<Book> bookSet = createBookSet(orderDTO);

        Order order = new Order(orderDTO.getCreatedAt(), orderDTO.getUpdateAt(), orderDTO.getStatus(), bookSet, user);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, OrderDTO orderDTO) {
        Order existingOrder;

        if(orderRepository.existsById(id)){
            existingOrder = getOrderById(id);

            existingOrder.setUpdateAt(orderDTO.getUpdateAt());
            existingOrder.setStatus(orderDTO.getStatus());

            Set<Book> bookSet = createBookSet(orderDTO);
            existingOrder.setBookSet(bookSet);

            User user = userRepository.getUserById(Long.valueOf(orderDTO.getUserId()));
            if(user != null){
                existingOrder.setUser(user);
            }else {
                throw new NoSuchElementException("User not found");
            }
        } else{
            throw new NoSuchElementException("Order ID " + id + " not found");
        }

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
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepository.getOrderByUserId(userId);
    }

    private Set<Book> createBookSet(OrderDTO orderDTO){
        Set<Book> bookSet = new HashSet<>();
        for (int i = 0; i < orderDTO.getBookSet().length; i++) {
            Book book = bookRepository.findBookById(Long.valueOf(orderDTO.getBookSet()[i]));
            bookSet.add(book);
        }
        return bookSet;
    }
    
}
