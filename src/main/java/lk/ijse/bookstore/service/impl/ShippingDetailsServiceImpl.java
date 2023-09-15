package lk.ijse.bookstore.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.bookstore.entity.ShippingDetails;
import lk.ijse.bookstore.repository.ShippingDetailsRepository;
import lk.ijse.bookstore.service.ShippingDetailsService;

@Service
public class ShippingDetailsServiceImpl implements ShippingDetailsService{

    private ShippingDetailsRepository shippingDetailsRepository;

    @Autowired
    public ShippingDetailsServiceImpl (ShippingDetailsRepository shippingDetailsRepository) {
        this.shippingDetailsRepository = shippingDetailsRepository;
    }

    @Override
    public List<ShippingDetails> getAllShippingDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllShippingDetails'");
    }

    @Override
    public ShippingDetails getShippingDetailsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShippingDetailsById'");
    }

    @Override
    public ShippingDetails createShippingDetails(ShippingDetails shippingDetails) {
        return shippingDetailsRepository.save(shippingDetails);
    }

    @Override
    public ShippingDetails updateShippingDetails(Long id, ShippingDetails shippingDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateShippingDetails'");
    }

    @Override
    public void deleteShippingDetails(Long id) {
        if(shippingDetailsRepository.existsById(id)){
            shippingDetailsRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Shipping Details ID: " + id + " not found");
        } 
    }
    
}
