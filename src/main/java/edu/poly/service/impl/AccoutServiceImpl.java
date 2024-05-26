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
//import edu.poly.domain.Account;
//import edu.poly.repository.AccountRepository;
//import edu.poly.service.AccountService;
//
//public class AccoutServiceImpl implements AccountService{
//	AccountRepository accountRepository;
//
//	public AccoutServiceImpl(AccountRepository accountRepository) {
//		this.accountRepository = accountRepository;
//	}
//
//	@Override
//	public <S extends Account> S save(S entity) {
//		return accountRepository.save(entity);
//	}
//
//	@Override
//	public <S extends Account> List<S> saveAll(Iterable<S> entities) {
//		return accountRepository.saveAll(entities);
//	}
//
//	@Override
//	public <S extends Account> Optional<S> findOne(Example<S> example) {
//		return accountRepository.findOne(example);
//	}
//
//	@Override
//	public List<Account> findAll(Sort sort) {
//		return accountRepository.findAll(sort);
//	}
//
//	@Override
//	public void flush() {
//		accountRepository.flush();
//	}
//
//	@Override
//	public Page<Account> findAll(Pageable pageable) {
//		return accountRepository.findAll(pageable);
//	}
//
//	@Override
//	public <S extends Account> S saveAndFlush(S entity) {
//		return accountRepository.saveAndFlush(entity);
//	}
//
//	@Override
//	public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
//		return accountRepository.saveAllAndFlush(entities);
//	}
//
//	@Override
//	public List<Account> findAll() {
//		return accountRepository.findAll();
//	}
//
//	@Override
//	public List<Account> findAllById(Iterable<String> ids) {
//		return accountRepository.findAllById(ids);
//	}
//
//	@Override
//	public Optional<Account> findById(String id) {
//		return accountRepository.findById(id);
//	}
//
//	@Override
//	public boolean existsById(String id) {
//		return accountRepository.existsById(id);
//	}
//
//	@Override
//	public void deleteAllByIdInBatch(Iterable<String> ids) {
//		accountRepository.deleteAllByIdInBatch(ids);
//	}
//
//	@Override
//	public <S extends Account> boolean exists(Example<S> example) {
//		return accountRepository.exists(example);
//	}
//
//	@Override
//	public Account getOne(String id) {
//		return accountRepository.getOne(id);
//	}
//
//	@Override
//	public long count() {
//		return accountRepository.count();
//	}
//
//	@Override
//	public void deleteById(String id) {
//		accountRepository.deleteById(id);
//	}
//
//	@Override
//	public Account getById(String id) {
//		return accountRepository.getById(id);
//	}
//
//	@Override
//	public void delete(Account entity) {
//		accountRepository.delete(entity);
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends String> ids) {
//		accountRepository.deleteAllById(ids);
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Account> entities) {
//		accountRepository.deleteAll(entities);
//	}
//
//	@Override
//	public void deleteAll() {
//		accountRepository.deleteAll();
//	}
//
//	
//	
//	
//	
//	
//	
//}
