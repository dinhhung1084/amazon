//package edu.poly.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import edu.poly.domain.Category;
//import edu.poly.repository.CategoryRepository;
//import edu.poly.service.CategoryService;
//
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//	CategoryRepository categoryRepository;
//
//	
//	
//	public CategoryServiceImpl(CategoryRepository categoryRepository) {
//		this.categoryRepository = categoryRepository;
//	}
//
//	@Override
//	public <S extends Category> S save(S entity) {
//		return categoryRepository.save(entity);
//	}
//
//	@Override
//	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
//		return categoryRepository.saveAll(entities);
//	}
//
//	@Override
//	public List<Category> findAll(Sort sort) {
//		return categoryRepository.findAll(sort);
//	}
//
//	@Override
//	public void flush() {
//		categoryRepository.flush();
//	}
//
//	@Override
//	public Page<Category> findAll(Pageable pageable) {
//		return categoryRepository.findAll(pageable);
//	}
//
//	@Override
//	public <S extends Category> S saveAndFlush(S entity) {
//		return categoryRepository.saveAndFlush(entity);
//	}
//
//	@Override
//	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
//		return categoryRepository.saveAllAndFlush(entities);
//	}
//
//	@Override
//	public List<Category> findAll() {
//		return categoryRepository.findAll();
//	}
//
//	@Override
//	public List<Category> findAllById(Iterable<Integer> ids) {
//		return categoryRepository.findAllById(ids);
//	}
//
//	@Override
//	public Optional<Category> findById(Integer id) {
//		return categoryRepository.findById(id);
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		return categoryRepository.existsById(id);
//	}
//
//	@Override
//	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
//		categoryRepository.deleteAllByIdInBatch(ids);
//	}
//
//	@Override
//	public <S extends Category> boolean exists(Example<S> example) {
//		return categoryRepository.exists(example);
//	}
//
//	@Override
//	public Category getOne(Integer id) {
//		return categoryRepository.getOne(id);
//	}
//
//	@Override
//	public long count() {
//		return categoryRepository.count();
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		categoryRepository.deleteById(id);
//	}
//
//	@Override
//	public Category getById(Integer id) {
//		return categoryRepository.getById(id);
//	}
//
//	@Override
//	public void delete(Category entity) {
//		categoryRepository.delete(entity);
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		categoryRepository.deleteAllById(ids);
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Category> entities) {
//		categoryRepository.deleteAll(entities);
//	}
//
//	@Override
//	public void deleteAll() {
//		categoryRepository.deleteAll();
//	}
//
//	
//	
//	
//}
