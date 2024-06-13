package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.domain.Order;
import edu.poly.repository.OrderRepository;
import edu.poly.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Page<Order> findPaginatedActivated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findByIsActivatedTrue(pageable);
    }

    public void deactivateOrder(Integer orderId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setActivated(false);
            orderRepository.save(order);
        }
    }

    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity);
    }

    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return orderRepository.saveAll(entities);
    }

    public List<Order> findAll(Sort sort) {
        return orderRepository.findAll(sort);
    }

    public void flush() {
        orderRepository.flush();
    }

    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public <S extends Order> S saveAndFlush(S entity) {
        return orderRepository.saveAndFlush(entity);
    }

    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return orderRepository.saveAllAndFlush(entities);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAllById(Iterable<Integer> ids) {
        return orderRepository.findAllById(ids);
    }

    public void deleteInBatch(Iterable<Order> entities) {
        orderRepository.deleteInBatch(entities);
    }

    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    public void deleteAllInBatch(Iterable<Order> entities) {
        orderRepository.deleteAllInBatch(entities);
    }

    public boolean existsById(Integer id) {
        return orderRepository.existsById(id);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        orderRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        orderRepository.deleteAllInBatch();
    }

    public Order getOne(Integer id) {
        return orderRepository.getOne(id);
    }

    public long count() {
        return orderRepository.count();
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order getById(Integer id) {
        return orderRepository.getById(id);
    }

    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        orderRepository.deleteAllById(ids);
    }

    public Order getReferenceById(Integer id) {
        return orderRepository.getReferenceById(id);
    }

    public void deleteAll(Iterable<? extends Order> entities) {
        orderRepository.deleteAll(entities);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

}