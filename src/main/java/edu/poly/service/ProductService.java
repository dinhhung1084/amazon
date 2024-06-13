package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.domain.Product;

public interface ProductService {

    public Page<Product> searchActiveProducts(String keywords, Pageable pageable);

    public Page<Product> findPaginatedActivated(int page, int size);

    void setStockToFalse(Integer productId);

    <S extends Product> S save(S entity);

    <S extends Product> List<S> saveAll(Iterable<S> entities);

    List<Product> findAll(Sort sort);

    void flush();

    Page<Product> findAll(Pageable pageable);

    <S extends Product> S saveAndFlush(S entity);

    <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

    List<Product> findAll();

    List<Product> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<Product> entities);

    Optional<Product> findById(Integer id);

    void deleteAllInBatch(Iterable<Product> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    Product getOne(Integer id);

    long count();

    void deleteById(Integer id);

    Product getById(Integer id);

    void delete(Product entity);

    void deleteAllById(Iterable<? extends Integer> ids);

    Product getReferenceById(Integer id);

    void deleteAll(Iterable<? extends Product> entities);

    void deleteAll();

}
