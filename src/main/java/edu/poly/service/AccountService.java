// package edu.poly.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import edu.poly.domain.Account;

// public interface AccountService {

// 	void deleteAll();

// 	void deleteAll(Iterable<? extends Account> entities);

// 	void deleteAllById(Iterable<? extends String> ids);

// 	void delete(Account entity);

// 	Account getById(String id);

// 	void deleteById(String id);

// 	long count();

// 	Account getOne(String id);

// 	<S extends Account> boolean exists(Example<S> example);

// 	void deleteAllByIdInBatch(Iterable<String> ids);

// 	boolean existsById(String id);

// 	Optional<Account> findById(String id);

// 	List<Account> findAllById(Iterable<String> ids);

// 	List<Account> findAll();

// 	<S extends Account> List<S> saveAllAndFlush(Iterable<S> entities);

// 	<S extends Account> S saveAndFlush(S entity);

// 	Page<Account> findAll(Pageable pageable);

// 	void flush();

// 	List<Account> findAll(Sort sort);

// 	<S extends Account> Optional<S> findOne(Example<S> example);

// 	<S extends Account> List<S> saveAll(Iterable<S> entities);

// 	<S extends Account> S save(S entity);

	
// }
