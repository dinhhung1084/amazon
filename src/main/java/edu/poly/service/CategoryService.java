//package edu.poly.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
//
//import edu.poly.domain.Category;
//
//public interface CategoryService {
//
//	void deleteAll();
//
//	void deleteAll(Iterable<? extends Category> entities);
//
//	void deleteAllById(Iterable<? extends Integer> ids);
//
//	void delete(Category entity);
//
//	Category getById(Integer id);
//
//	void deleteById(Integer id);
//
//	long count();
//
//	Category getOne(Integer id);
//
//	<S extends Category> boolean exists(Example<S> example);
//
//	void deleteAllByIdInBatch(Iterable<Integer> ids);
//
//	boolean existsById(Integer id);
//
//	Optional<Category> findById(Integer id);
//
//	List<Category> findAllById(Iterable<Integer> ids);
//
//	List<Category> findAll();
//
//	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);
//
//	<S extends Category> S saveAndFlush(S entity);
//
//	Page<Category> findAll(Pageable pageable);
//
//	void flush();
//
//	List<Category> findAll(Sort sort);
//
//	<S extends Category> List<S> saveAll(Iterable<S> entities);
//
//	<S extends Category> S save(S entity);
//
//	
//}
