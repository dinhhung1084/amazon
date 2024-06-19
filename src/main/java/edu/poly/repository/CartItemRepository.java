package edu.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.domain.CartItem;
import edu.poly.domain.Customer;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // List<CartItem> findByCustomer_Id(int customerId);

    @Query("SELECT c FROM CartItem c WHERE c.customer.id = :customerId")
    List<CartItem> findByCustomerId(@Param("customerId") int customerId);

    @Query("SELECT c FROM CartItem c WHERE c.customer.id = :customerId AND c.product.id = :productId")
    CartItem findByCustomerIdAndProductId(@Param("customerId") Integer customerId,
            @Param("productId") Integer productId);

    void deleteByCustomer(Customer customer);
}
