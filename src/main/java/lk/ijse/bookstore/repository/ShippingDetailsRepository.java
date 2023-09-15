package lk.ijse.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.bookstore.entity.ShippingDetails;

@Repository
public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, Long> {
   
}
