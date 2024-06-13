package edu.poly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Page<Order> findByIsActivatedTrue(Pageable pageable);

    // Page<Product> findByNameContainingAndIsActivatedTrue(String keywords,
    // Pageable pageable);
}
