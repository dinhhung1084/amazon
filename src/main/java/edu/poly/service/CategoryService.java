package edu.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.domain.Category;

public interface CategoryService {

    <S extends Category> S save(S entity);

    <S extends Category> List<S> saveAll(Iterable<S> entities);

    List<Category> findAll(Sort sort);

    void flush();

    Page<Category> findAll(Pageable pageable);

    <S extends Category> S saveAndFlush(S entity);

    <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

    List<Category> findAll();

    List<Category> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<Category> entities);

    Optional<Category> findById(Integer id);

    void deleteAllInBatch(Iterable<Category> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    Category getOne(Integer id);

    long count();

    void deleteById(Integer id);

    Category getById(Integer id);

    void delete(Category entity);

    void deleteAllById(Iterable<? extends Integer> ids);

    Category getReferenceById(Integer id);

    void deleteAll(Iterable<? extends Category> entities);

    void deleteAll();

}