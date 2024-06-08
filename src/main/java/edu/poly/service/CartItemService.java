// package edu.poly.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import edu.poly.domain.CartItem;

// public interface CartItemService {

// 	void deleteAll();

// 	void deleteAll(Iterable<? extends CartItem> entities);

// 	void deleteAllById(Iterable<? extends Integer> ids);

// 	void delete(CartItem entity);

// 	CartItem getById(Integer id);

// 	void deleteById(Integer id);

// 	long count();

// 	<S extends CartItem> boolean exists(Example<S> example);

// 	boolean existsById(Integer id);

// 	Optional<CartItem> findById(Integer id);

// 	List<CartItem> findAllById(Iterable<Integer> ids);

// 	List<CartItem> findAll();

// 	<S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities);

// 	<S extends CartItem> S saveAndFlush(S entity);

// 	Page<CartItem> findAll(Pageable pageable);

// 	void flush();

// 	List<CartItem> findAll(Sort sort);

// 	<S extends CartItem> Optional<S> findOne(Example<S> example);

// 	<S extends CartItem> List<S> saveAll(Iterable<S> entities);

// 	<S extends CartItem> S save(S entity);

// }
