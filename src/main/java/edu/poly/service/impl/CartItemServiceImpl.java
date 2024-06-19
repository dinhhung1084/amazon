package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.domain.CartItem;
import edu.poly.domain.Customer;
import edu.poly.repository.CartItemRepository;
import edu.poly.repository.CustomerRepository;
import edu.poly.service.CartItemService;
import jakarta.transaction.Transactional;

@Service
public class CartItemServiceImpl implements CartItemService {
    CartItemRepository cartItemRepository;
    CustomerRepository customerRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, CustomerRepository customerRepository) {
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void deleteCartItemsByCustomerId(int customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + customerId));
        cartItemRepository.deleteByCustomer(customer);
    }

    public List<CartItem> listCartItem(int customerId) {
        return cartItemRepository.findByCustomerId(customerId);
    }

    public CartItem findByProductId(int customer, int productId) {
        return cartItemRepository.findByCustomerIdAndProductId(customer, productId);
    }

    public <S extends CartItem> S save(S entity) {
        return cartItemRepository.save(entity);
    }

    public <S extends CartItem> List<S> saveAll(Iterable<S> entities) {
        return cartItemRepository.saveAll(entities);
    }

    public List<CartItem> findAll(Sort sort) {
        return cartItemRepository.findAll(sort);
    }

    public void flush() {
        cartItemRepository.flush();
    }

    public Page<CartItem> findAll(Pageable pageable) {
        return cartItemRepository.findAll(pageable);
    }

    public <S extends CartItem> S saveAndFlush(S entity) {
        return cartItemRepository.saveAndFlush(entity);
    }

    public <S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities) {
        return cartItemRepository.saveAllAndFlush(entities);
    }

    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public List<CartItem> findAllById(Iterable<Integer> ids) {
        return cartItemRepository.findAllById(ids);
    }

    public void deleteInBatch(Iterable<CartItem> entities) {
        cartItemRepository.deleteInBatch(entities);
    }

    public Optional<CartItem> findById(Integer id) {
        return cartItemRepository.findById(id);
    }

    public void deleteAllInBatch(Iterable<CartItem> entities) {
        cartItemRepository.deleteAllInBatch(entities);
    }

    public boolean existsById(Integer id) {
        return cartItemRepository.existsById(id);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        cartItemRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        cartItemRepository.deleteAllInBatch();
    }

    public CartItem getOne(Integer id) {
        return cartItemRepository.getOne(id);
    }

    public long count() {
        return cartItemRepository.count();
    }

    public void deleteById(Integer id) {
        cartItemRepository.deleteById(id);
    }

    public CartItem getById(Integer id) {
        return cartItemRepository.getById(id);
    }

    public void delete(CartItem entity) {
        cartItemRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        cartItemRepository.deleteAllById(ids);
    }

    public CartItem getReferenceById(Integer id) {
        return cartItemRepository.getReferenceById(id);
    }

    public void deleteAll(Iterable<? extends CartItem> entities) {
        cartItemRepository.deleteAll(entities);
    }

    public void deleteAll() {
        cartItemRepository.deleteAll();
    }

}
