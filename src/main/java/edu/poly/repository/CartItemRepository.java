package edu.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.domain.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
