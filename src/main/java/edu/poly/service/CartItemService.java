package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.domain.CartItem;

public interface CartItemService {

    <S extends CartItem> S save(S entity);

    <S extends CartItem> List<S> saveAll(Iterable<S> entities);

    void deleteCartItemsByCustomerId(int customerId);

    List<CartItem> findAll(Sort sort);

    void flush();

    CartItem findByProductId(int customer, int productId);

    List<CartItem> listCartItem(int customerId);

    Page<CartItem> findAll(Pageable pageable);

    <S extends CartItem> S saveAndFlush(S entity);

    <S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities);

    List<CartItem> findAll();

    List<CartItem> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<CartItem> entities);

    Optional<CartItem> findById(Integer id);

    void deleteAllInBatch(Iterable<CartItem> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    CartItem getOne(Integer id);

    long count();

    void deleteById(Integer id);

    CartItem getById(Integer id);

    void delete(CartItem entity);

    void deleteAllById(Iterable<? extends Integer> ids);

    CartItem getReferenceById(Integer id);

    void deleteAll(Iterable<? extends CartItem> entities);

    void deleteAll();

}
