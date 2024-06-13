package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.domain.Product;
import edu.poly.repository.ProductRepository;
import edu.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> searchActiveProducts(String keywords, Pageable pageable) {
        return productRepository.findByNameContainingAndStockTrue(keywords, pageable);
    }

    public List<Product> findStock() {
        return productRepository.findByStockTrue();
    }

    public Page<Product> findPaginatedActivated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByStockTrue(pageable);
    }

    public void setStockToFalse(Integer productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        productOptional.ifPresent(product -> {
            product.setStock(false);
            productRepository.save(product);
        });
    }

    //
    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return productRepository.saveAll(entities);
    }

    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    public void flush() {
        productRepository.flush();
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public <S extends Product> S saveAndFlush(S entity) {
        return productRepository.saveAndFlush(entity);
    }

    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return productRepository.saveAllAndFlush(entities);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllById(Iterable<Integer> ids) {
        return productRepository.findAllById(ids);
    }

    public void deleteInBatch(Iterable<Product> entities) {
        productRepository.deleteInBatch(entities);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteAllInBatch(Iterable<Product> entities) {
        productRepository.deleteAllInBatch(entities);
    }

    public boolean existsById(Integer id) {
        return productRepository.existsById(id);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        productRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        productRepository.deleteAllInBatch();
    }

    public Product getOne(Integer id) {
        return productRepository.getOne(id);
    }

    public long count() {
        return productRepository.count();
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product getById(Integer id) {
        return productRepository.getById(id);
    }

    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        productRepository.deleteAllById(ids);
    }

    public Product getReferenceById(Integer id) {
        return productRepository.getReferenceById(id);
    }

    public void deleteAll(Iterable<? extends Product> entities) {
        productRepository.deleteAll(entities);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

}
