//package edu.poly.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import edu.poly.domain.Order;
//import edu.poly.repository.ProductRepository;
//import edu.poly.service.ProductService;
//
//public class ProductServiceImpl implements ProductService {
//
//	ProductRepository productRepository;
//
//	public ProductServiceImpl(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}
//
//	@Override
//	public <S extends Order> S save(S entity) {
//		return productRepository.save(entity);
//	}
//
//	@Override
//	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
//		return productRepository.saveAll(entities);
//	}
//
//	@Override
//	public <S extends Order> Optional<S> findOne(Example<S> example) {
//		return productRepository.findOne(example);
//	}
//
//	@Override
//	public List<Order> findAll(Sort sort) {
//		return productRepository.findAll(sort);
//	}
//
//	@Override
//	public void flush() {
//		productRepository.flush();
//	}
//
//	@Override
//	public Page<Order> findAll(Pageable pageable) {
//		return productRepository.findAll(pageable);
//	}
//
//	@Override
//	public <S extends Order> S saveAndFlush(S entity) {
//		return productRepository.saveAndFlush(entity);
//	}
//
//	@Override
//	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
//		return productRepository.saveAllAndFlush(entities);
//	}
//
//	@Override
//	public List<Order> findAll() {
//		return productRepository.findAll();
//	}
//
//	@Override
//	public List<Order> findAllById(Iterable<Integer> ids) {
//		return productRepository.findAllById(ids);
//	}
//
//	@Override
//	public Optional<Order> findById(Integer id) {
//		return productRepository.findById(id);
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		return productRepository.existsById(id);
//	}
//
//	@Override
//	public Order getOne(Integer id) {
//		return productRepository.getOne(id);
//	}
//
//	@Override
//	public long count() {
//		return productRepository.count();
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		productRepository.deleteById(id);
//	}
//
//	@Override
//	public Order getById(Integer id) {
//		return productRepository.getById(id);
//	}
//
//	@Override
//	public void delete(Order entity) {
//		productRepository.delete(entity);
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		productRepository.deleteAllById(ids);
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Order> entities) {
//		productRepository.deleteAll(entities);
//	}
//
//	@Override
//	public void deleteAll() {
//		productRepository.deleteAll();
//	}
//	
//	
//	
//	
//}
