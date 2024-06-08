// package edu.poly.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import edu.poly.domain.CartItem;
// import edu.poly.repository.CartItemRepository;
// import edu.poly.service.CartItemService;

// public class CartItemServiceImpl implements CartItemService {
// 	CartItemRepository cartItemRepository;

// 	public CartItemServiceImpl(CartItemRepository cartItemRepository) {
// 		this.cartItemRepository = cartItemRepository;
// 	}

// 	@Override
// 	public <S extends CartItem> S save(S entity) {
// 		return cartItemRepository.save(entity);
// 	}

// 	@Override
// 	public <S extends CartItem> List<S> saveAll(Iterable<S> entities) {
// 		return cartItemRepository.saveAll(entities);
// 	}

// 	@Override
// 	public <S extends CartItem> Optional<S> findOne(Example<S> example) {
// 		return cartItemRepository.findOne(example);
// 	}

// 	@Override
// 	public List<CartItem> findAll(Sort sort) {
// 		return cartItemRepository.findAll(sort);
// 	}

// 	@Override
// 	public void flush() {
// 		cartItemRepository.flush();
// 	}

// 	@Override
// 	public Page<CartItem> findAll(Pageable pageable) {
// 		return cartItemRepository.findAll(pageable);
// 	}

// 	@Override
// 	public <S extends CartItem> S saveAndFlush(S entity) {
// 		return cartItemRepository.saveAndFlush(entity);
// 	}

// 	@Override
// 	public <S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities) {
// 		return cartItemRepository.saveAllAndFlush(entities);
// 	}

// 	@Override
// 	public List<CartItem> findAll() {
// 		return cartItemRepository.findAll();
// 	}

// 	@Override
// 	public List<CartItem> findAllById(Iterable<Integer> ids) {
// 		return cartItemRepository.findAllById(ids);
// 	}

// 	@Override
// 	public Optional<CartItem> findById(Integer id) {
// 		return cartItemRepository.findById(id);
// 	}

// 	@Override
// 	public boolean existsById(Integer id) {
// 		return cartItemRepository.existsById(id);
// 	}

// 	@Override
// 	public <S extends CartItem> boolean exists(Example<S> example) {
// 		return cartItemRepository.exists(example);
// 	}

// 	@Override
// 	public long count() {
// 		return cartItemRepository.count();
// 	}

// 	@Override
// 	public void deleteById(Integer id) {
// 		cartItemRepository.deleteById(id);
// 	}

// 	@Override
// 	public CartItem getById(Integer id) {
// 		return cartItemRepository.getById(id);
// 	}

// 	@Override
// 	public void delete(CartItem entity) {
// 		cartItemRepository.delete(entity);
// 	}

// 	@Override
// 	public void deleteAllById(Iterable<? extends Integer> ids) {
// 		cartItemRepository.deleteAllById(ids);
// 	}

// 	@Override
// 	public void deleteAll(Iterable<? extends CartItem> entities) {
// 		cartItemRepository.deleteAll(entities);
// 	}

// 	@Override
// 	public void deleteAll() {
// 		cartItemRepository.deleteAll();
// 	}
	
	
	
// }
