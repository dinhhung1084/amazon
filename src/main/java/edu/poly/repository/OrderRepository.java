package edu.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.domain.Product;

public interface OrderRepository extends JpaRepository<Product, Integer> {

}
