package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.domain.OrderDetail;

public interface OrderDetailService {

    Page<OrderDetail> findPaginatedActivated(int page, int size);

    void deactivateOrder(Integer orderId);

    <S extends OrderDetail> S save(S entity);

    <S extends OrderDetail> List<S> saveAll(Iterable<S> entities);

    List<OrderDetail> findAll(Sort sort);

    void flush();

    Page<OrderDetail> findAll(Pageable pageable);

    <S extends OrderDetail> S saveAndFlush(S entity);

    <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities);

    List<OrderDetail> findAll();

    List<OrderDetail> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<OrderDetail> entities);

    Optional<OrderDetail> findById(Integer id);

    void deleteAllInBatch(Iterable<OrderDetail> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    OrderDetail getOne(Integer id);

    long count();

    void deleteById(Integer id);

    OrderDetail getById(Integer id);

    void delete(OrderDetail entity);

    void deleteAllById(Iterable<? extends Integer> ids);

    OrderDetail getReferenceById(Integer id);

    void deleteAll(Iterable<? extends OrderDetail> entities);

    void deleteAll();

}
