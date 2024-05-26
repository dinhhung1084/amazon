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
//import edu.poly.domain.OrderDetail;
//import edu.poly.repository.OrderDetailRepository;
//import edu.poly.service.OrderDetailService;
//
//public class OrderDetailServiceImpl implements OrderDetailService{
//
//	OrderDetailRepository orderDetailRepository;
//
//	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
//		this.orderDetailRepository = orderDetailRepository;
//	}
//
//	@Override
//	public <S extends OrderDetail> S save(S entity) {
//		return orderDetailRepository.save(entity);
//	}
//
//	@Override
//	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
//		return orderDetailRepository.saveAll(entities);
//	}
//
//	@Override
//	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
//		return orderDetailRepository.findOne(example);
//	}
//
//	@Override
//	public List<OrderDetail> findAll(Sort sort) {
//		return orderDetailRepository.findAll(sort);
//	}
//
//	@Override
//	public void flush() {
//		orderDetailRepository.flush();
//	}
//
//	@Override
//	public Page<OrderDetail> findAll(Pageable pageable) {
//		return orderDetailRepository.findAll(pageable);
//	}
//
//	@Override
//	public <S extends OrderDetail> S saveAndFlush(S entity) {
//		return orderDetailRepository.saveAndFlush(entity);
//	}
//
//	@Override
//	public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
//		return orderDetailRepository.saveAllAndFlush(entities);
//	}
//
//	@Override
//	public List<OrderDetail> findAll() {
//		return orderDetailRepository.findAll();
//	}
//
//	@Override
//	public List<OrderDetail> findAllById(Iterable<Integer> ids) {
//		return orderDetailRepository.findAllById(ids);
//	}
//
//	@Override
//	public Optional<OrderDetail> findById(Integer id) {
//		return orderDetailRepository.findById(id);
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		return orderDetailRepository.existsById(id);
//	}
//
//	@Override
//	public OrderDetail getOne(Integer id) {
//		return orderDetailRepository.getOne(id);
//	}
//
//	@Override
//	public long count() {
//		return orderDetailRepository.count();
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		orderDetailRepository.deleteById(id);
//	}
//
//	@Override
//	public OrderDetail getById(Integer id) {
//		return orderDetailRepository.getById(id);
//	}
//
//	@Override
//	public void delete(OrderDetail entity) {
//		orderDetailRepository.delete(entity);
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		orderDetailRepository.deleteAllById(ids);
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends OrderDetail> entities) {
//		orderDetailRepository.deleteAll(entities);
//	}
//
//	@Override
//	public void deleteAll() {
//		orderDetailRepository.deleteAll();
//	}
//	
//	
//	
//}
