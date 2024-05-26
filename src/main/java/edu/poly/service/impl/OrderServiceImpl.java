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
//import edu.poly.domain.Product;
//import edu.poly.repository.OrderRepository;
//import edu.poly.service.OrderService;
//
//public class OrderServiceImpl implements OrderService{
//
//	OrderRepository orderRepository;
//
//	public OrderServiceImpl(OrderRepository orderRepository) {
//		this.orderRepository = orderRepository;
//	}
//
//	@Override
//	public <S extends Product> S save(S entity) {
//		return orderRepository.save(entity);
//	}
//
//	@Override
//	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
//		return orderRepository.saveAll(entities);
//	}
//
//	@Override
//	public <S extends Product> Optional<S> findOne(Example<S> example) {
//		return orderRepository.findOne(example);
//	}
//
//	@Override
//	public List<Product> findAll(Sort sort) {
//		return orderRepository.findAll(sort);
//	}
//
//	@Override
//	public void flush() {
//		orderRepository.flush();
//	}
//
//	@Override
//	public Page<Product> findAll(Pageable pageable) {
//		return orderRepository.findAll(pageable);
//	}
//
//	@Override
//	public <S extends Product> S saveAndFlush(S entity) {
//		return orderRepository.saveAndFlush(entity);
//	}
//
//	@Override
//	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
//		return orderRepository.saveAllAndFlush(entities);
//	}
//
//	@Override
//	public List<Product> findAll() {
//		return orderRepository.findAll();
//	}
//
//	@Override
//	public List<Product> findAllById(Iterable<Integer> ids) {
//		return orderRepository.findAllById(ids);
//	}
//
//	@Override
//	public Optional<Product> findById(Integer id) {
//		return orderRepository.findById(id);
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		return orderRepository.existsById(id);
//	}
//
//	@Override
//	public Product getOne(Integer id) {
//		return orderRepository.getOne(id);
//	}
//
//	@Override
//	public long count() {
//		return orderRepository.count();
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		orderRepository.deleteById(id);
//	}
//
//	@Override
//	public Product getById(Integer id) {
//		return orderRepository.getById(id);
//	}
//
//	@Override
//	public void delete(Product entity) {
//		orderRepository.delete(entity);
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		orderRepository.deleteAllById(ids);
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Product> entities) {
//		orderRepository.deleteAll(entities);
//	}
//
//	@Override
//	public void deleteAll() {
//		orderRepository.deleteAll();
//	}
//	
//	
//}
