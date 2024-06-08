// package edu.poly.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import edu.poly.domain.Product;

// public interface OrderService  {

// 	void deleteAll();

// 	void deleteAll(Iterable<? extends Product> entities);

// 	void deleteAllById(Iterable<? extends Integer> ids);

// 	void delete(Product entity);

// 	Product getById(Integer id);

// 	void deleteById(Integer id);

// 	long count();

// 	Product getOne(Integer id);

// 	boolean existsById(Integer id);

// 	Optional<Product> findById(Integer id);

// 	List<Product> findAllById(Iterable<Integer> ids);

// 	List<Product> findAll();

// 	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

// 	<S extends Product> S saveAndFlush(S entity);

// 	Page<Product> findAll(Pageable pageable);

// 	void flush();

// 	List<Product> findAll(Sort sort);

// 	<S extends Product> Optional<S> findOne(Example<S> example);

// 	<S extends Product> List<S> saveAll(Iterable<S> entities);

// 	<S extends Product> S save(S entity);

// }
