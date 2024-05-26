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
//import edu.poly.domain.OrderDetail;
//
//public interface OrderDetailService {
//
//	void deleteAll();
//
//	void deleteAll(Iterable<? extends OrderDetail> entities);
//
//	void deleteAllById(Iterable<? extends Integer> ids);
//
//	void delete(OrderDetail entity);
//
//	OrderDetail getById(Integer id);
//
//	void deleteById(Integer id);
//
//	long count();
//
//	OrderDetail getOne(Integer id);
//
//	boolean existsById(Integer id);
//
//	Optional<OrderDetail> findById(Integer id);
//
//	List<OrderDetail> findAllById(Iterable<Integer> ids);
//
//	List<OrderDetail> findAll();
//
//	<S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities);
//
//	<S extends OrderDetail> S saveAndFlush(S entity);
//
//	Page<OrderDetail> findAll(Pageable pageable);
//
//	void flush();
//
//	List<OrderDetail> findAll(Sort sort);
//
//	<S extends OrderDetail> Optional<S> findOne(Example<S> example);
//
//	<S extends OrderDetail> List<S> saveAll(Iterable<S> entities);
//
//	<S extends OrderDetail> S save(S entity);
//
//}
