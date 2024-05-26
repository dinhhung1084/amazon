//package edu.poly.service;
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
//
//public interface ProductService {
//
//	void deleteAll();
//
//	void deleteAll(Iterable<? extends Order> entities);
//
//	void deleteAllById(Iterable<? extends Integer> ids);
//
//	void delete(Order entity);
//
//	Order getById(Integer id);
//
//	void deleteById(Integer id);
//
//	long count();
//
//	Order getOne(Integer id);
//
//	boolean existsById(Integer id);
//
//	Optional<Order> findById(Integer id);
//
//	List<Order> findAllById(Iterable<Integer> ids);
//
//	List<Order> findAll();
//
//	<S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);
//
//	<S extends Order> S saveAndFlush(S entity);
//
//	Page<Order> findAll(Pageable pageable);
//
//	void flush();
//
//	List<Order> findAll(Sort sort);
//
//	<S extends Order> Optional<S> findOne(Example<S> example);
//
//	<S extends Order> List<S> saveAll(Iterable<S> entities);
//
//	<S extends Order> S save(S entity);
//
//}
