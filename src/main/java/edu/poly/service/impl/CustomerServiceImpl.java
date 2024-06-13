package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.domain.Customer;
import edu.poly.repository.CustomerRepository;
import edu.poly.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> searchActiveCustomers(String keywords, Pageable pageable) {
        return customerRepository.findByNameContainingAndIsActivatedTrue(keywords, pageable);
    }

    public List<Customer> findActivatedCustomer() {
        return customerRepository.findByIsActivatedTrue();
    }

    public Page<Customer> findPaginatedActivated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerRepository.findByIsActivatedTrue(pageable);
    }

    public void deactivateCustomer(Integer categoryId) {
        Optional<Customer> customerOpt = customerRepository.findById(categoryId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setActivated(false);
            customerRepository.save(customer);
        }
    }

    public <S extends Customer> S save(S entity) {
        return customerRepository.save(entity);
    }

    public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
        return customerRepository.saveAll(entities);
    }

    public List<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    public void flush() {
        customerRepository.flush();
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public <S extends Customer> S saveAndFlush(S entity) {
        return customerRepository.saveAndFlush(entity);
    }

    public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return customerRepository.saveAllAndFlush(entities);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findAllById(Iterable<Integer> ids) {
        return customerRepository.findAllById(ids);
    }

    public void deleteInBatch(Iterable<Customer> entities) {
        customerRepository.deleteInBatch(entities);
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public void deleteAllInBatch(Iterable<Customer> entities) {
        customerRepository.deleteAllInBatch(entities);
    }

    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        customerRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        customerRepository.deleteAllInBatch();
    }

    public Customer getOne(Integer id) {
        return customerRepository.getOne(id);
    }

    public long count() {
        return customerRepository.count();
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    public Customer getById(Integer id) {
        return customerRepository.getById(id);
    }

    public void delete(Customer entity) {
        customerRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        customerRepository.deleteAllById(ids);
    }

    public Customer getReferenceById(Integer id) {
        return customerRepository.getReferenceById(id);
    }

    public void deleteAll(Iterable<? extends Customer> entities) {
        customerRepository.deleteAll(entities);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

}
