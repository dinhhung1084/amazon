package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.domain.Order;

public interface OrderService {

    Page<Order> findPaginatedActivated(int page, int size);

    void deactivateOrder(Integer orderId);

    <S extends Order> S save(S entity);

    <S extends Order> List<S> saveAll(Iterable<S> entities);

    List<Order> findAll(Sort sort);

    void flush();

    Page<Order> findAll(Pageable pageable);

    <S extends Order> S saveAndFlush(S entity);

    <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);

    List<Order> findAll();

    List<Order> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<Order> entities);

    Optional<Order> findById(Integer id);

    void deleteAllInBatch(Iterable<Order> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    Order getOne(Integer id);

    long count();

    void deleteById(Integer id);

    Order getById(Integer id);

    void delete(Order entity);

    void deleteAllById(Iterable<? extends Integer> ids);

    Order getReferenceById(Integer id);

    void deleteAll(Iterable<? extends Order> entities);

    void deleteAll();

}
