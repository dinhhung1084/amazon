package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.domain.Category;
import edu.poly.repository.CategoryRepository;
import edu.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public <S extends Category> S save(S entity) {
        return categoryRepository.save(entity);
    }

    public <S extends Category> List<S> saveAll(Iterable<S> entities) {
        return categoryRepository.saveAll(entities);
    }

    public List<Category> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    public List<Category> findIsActivated() {
        return categoryRepository.findByIsActivatedTrue();
    }

    public void flush() {
        categoryRepository.flush();
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Page<Category> searchActiveProducts(String keywords, Pageable pageable) {
        return categoryRepository.findByNameContainingAndIsActivatedTrue(keywords, pageable);
    }

    public Page<Category> findPaginatedActivated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryRepository.findByIsActivatedTrue(pageable);
    }

    public <S extends Category> S saveAndFlush(S entity) {
        return categoryRepository.saveAndFlush(entity);
    }

    public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
        return categoryRepository.saveAllAndFlush(entities);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findAllById(Iterable<Integer> ids) {
        return categoryRepository.findAllById(ids);
    }

    public void deleteInBatch(Iterable<Category> entities) {
        categoryRepository.deleteInBatch(entities);
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    // delete category
    public void deactivateCategory(Integer categoryId) {
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setActivated(false);
            categoryRepository.save(category);
        }
    }

    public void deleteAllInBatch(Iterable<Category> entities) {
        categoryRepository.deleteAllInBatch(entities);
    }

    public boolean existsById(Integer id) {
        return categoryRepository.existsById(id);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        categoryRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        categoryRepository.deleteAllInBatch();
    }

    public Category getOne(Integer id) {
        return categoryRepository.getOne(id);
    }

    public long count() {
        return categoryRepository.count();
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category getById(Integer id) {
        return categoryRepository.getById(id);
    }

    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        categoryRepository.deleteAllById(ids);
    }

    public Category getReferenceById(Integer id) {
        return categoryRepository.getReferenceById(id);
    }

    public void deleteAll(Iterable<? extends Category> entities) {
        categoryRepository.deleteAll(entities);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

}
