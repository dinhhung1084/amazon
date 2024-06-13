package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.domain.Customer;

public interface CustomerService {

    List<Customer> findActivatedCustomer();

    Page<Customer> findPaginatedActivated(int page, int size);

    Page<Customer> searchActiveCustomers(String keywords, Pageable pageable);

    void deactivateCustomer(Integer categoryId);

    <S extends Customer> S save(S entity);

    <S extends Customer> List<S> saveAll(Iterable<S> entities);

    List<Customer> findAll(Sort sort);

    void flush();

    Page<Customer> findAll(Pageable pageable);

    <S extends Customer> S saveAndFlush(S entity);

    <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

    List<Customer> findAll();

    List<Customer> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<Customer> entities);

    Optional<Customer> findById(Integer id);

    void deleteAllInBatch(Iterable<Customer> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    Customer getOne(Integer id);

    long count();

    void deleteById(Integer id);

    Customer getById(Integer id);

    void delete(Customer entity);

    void deleteAllById(Iterable<? extends Integer> ids);

    Customer getReferenceById(Integer id);

    void deleteAll(Iterable<? extends Customer> entities);

    void deleteAll();

}
