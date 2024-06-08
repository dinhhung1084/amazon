// package edu.poly.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import edu.poly.domain.Customer;
// import edu.poly.repository.CustomerRepository;
// import edu.poly.service.CustomerService;

// public class CustomerServiceImpl implements CustomerService{
		
	
// 	CustomerRepository customerRepository;

// 	public CustomerServiceImpl(CustomerRepository customerRepository) {
// 		this.customerRepository = customerRepository;
// 	}

// 	@Override
// 	public <S extends Customer> S save(S entity) {
// 		return customerRepository.save(entity);
// 	}

// 	@Override
// 	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
// 		return customerRepository.saveAll(entities);
// 	}

// 	@Override
// 	public <S extends Customer> Optional<S> findOne(Example<S> example) {
// 		return customerRepository.findOne(example);
// 	}

// 	@Override
// 	public List<Customer> findAll(Sort sort) {
// 		return customerRepository.findAll(sort);
// 	}

// 	@Override
// 	public void flush() {
// 		customerRepository.flush();
// 	}

// 	@Override
// 	public Page<Customer> findAll(Pageable pageable) {
// 		return customerRepository.findAll(pageable);
// 	}

// 	@Override
// 	public <S extends Customer> S saveAndFlush(S entity) {
// 		return customerRepository.saveAndFlush(entity);
// 	}

// 	@Override
// 	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
// 		return customerRepository.saveAllAndFlush(entities);
// 	}

// 	@Override
// 	public List<Customer> findAll() {
// 		return customerRepository.findAll();
// 	}

// 	@Override
// 	public List<Customer> findAllById(Iterable<Integer> ids) {
// 		return customerRepository.findAllById(ids);
// 	}

// 	@Override
// 	public Optional<Customer> findById(Integer id) {
// 		return customerRepository.findById(id);
// 	}

// 	@Override
// 	public boolean existsById(Integer id) {
// 		return customerRepository.existsById(id);
// 	}

// 	@Override
// 	public Customer getOne(Integer id) {
// 		return customerRepository.getOne(id);
// 	}

// 	@Override
// 	public long count() {
// 		return customerRepository.count();
// 	}

// 	@Override
// 	public void deleteById(Integer id) {
// 		customerRepository.deleteById(id);
// 	}

// 	@Override
// 	public Customer getById(Integer id) {
// 		return customerRepository.getById(id);
// 	}

// 	@Override
// 	public void delete(Customer entity) {
// 		customerRepository.delete(entity);
// 	}

// 	@Override
// 	public void deleteAllById(Iterable<? extends Integer> ids) {
// 		customerRepository.deleteAllById(ids);
// 	}

// 	@Override
// 	public void deleteAll(Iterable<? extends Customer> entities) {
// 		customerRepository.deleteAll(entities);
// 	}

// 	@Override
// 	public void deleteAll() {
// 		customerRepository.deleteAll();
// 	}
	
	
// }
