package edu.poly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findByIsActivatedTrue(Pageable pageable);

    Page<Customer> findByNameContainingAndIsActivatedTrue(String keywords, Pageable pageable);
}
