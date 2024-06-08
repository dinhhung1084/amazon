// package edu.poly.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import edu.poly.domain.Customer;

// public interface CustomerService {

// 	void deleteAll();

// 	void deleteAll(Iterable<? extends Customer> entities);

// 	void deleteAllById(Iterable<? extends Integer> ids);

// 	void delete(Customer entity);

// 	Customer getById(Integer id);

// 	void deleteById(Integer id);

// 	long count();

// 	Customer getOne(Integer id);

// 	boolean existsById(Integer id);

// 	Optional<Customer> findById(Integer id);

// 	List<Customer> findAllById(Iterable<Integer> ids);

// 	List<Customer> findAll();

// 	<S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

// 	<S extends Customer> S saveAndFlush(S entity);

// 	Page<Customer> findAll(Pageable pageable);

// 	void flush();

// 	List<Customer> findAll(Sort sort);

// 	<S extends Customer> Optional<S> findOne(Example<S> example);

// 	<S extends Customer> List<S> saveAll(Iterable<S> entities);

// 	<S extends Customer> S save(S entity);

// }
