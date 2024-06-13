package edu.poly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByStockTrue();

    Page<Product> findByStockTrue(Pageable pageable);

    Page<Product> findByNameContainingAndStockTrue(String keywords, Pageable pageable);
}
