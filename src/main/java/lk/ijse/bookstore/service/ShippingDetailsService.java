package lk.ijse.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.ShippingDetails;

@Service
public interface ShippingDetailsService {
    List<ShippingDetails> getAllShippingDetails();
    ShippingDetails getShippingDetailsById(Long id);
    ShippingDetails createShippingDetails(ShippingDetails shippingDetails);
    ShippingDetails updateShippingDetails(Long id, ShippingDetails shippingDetails);
    void deleteShippingDetails(Long id);
}
