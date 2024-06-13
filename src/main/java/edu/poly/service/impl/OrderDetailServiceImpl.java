package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.domain.OrderDetail;
import edu.poly.repository.OrderDetailRepository;
import edu.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public Page<OrderDetail> findPaginatedActivated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderDetailRepository.findByIsActivatedTrue(pageable);
    }

    public void deactivateOrder(Integer orderId) {
        Optional<OrderDetail> orderOpt = orderDetailRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            OrderDetail orderDetail = orderOpt.get();
            orderDetail.setActivated(false);
            orderDetailRepository.save(orderDetail);
        }
    }

    public <S extends OrderDetail> S save(S entity) {
        return orderDetailRepository.save(entity);
    }

    public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
        return orderDetailRepository.saveAll(entities);
    }

    public List<OrderDetail> findAll(Sort sort) {
        return orderDetailRepository.findAll(sort);
    }

    public void flush() {
        orderDetailRepository.flush();
    }

    public Page<OrderDetail> findAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    public <S extends OrderDetail> S saveAndFlush(S entity) {
        return orderDetailRepository.saveAndFlush(entity);
    }

    public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
        return orderDetailRepository.saveAllAndFlush(entities);
    }

    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    public List<OrderDetail> findAllById(Iterable<Integer> ids) {
        return orderDetailRepository.findAllById(ids);
    }

    public void deleteInBatch(Iterable<OrderDetail> entities) {
        orderDetailRepository.deleteInBatch(entities);
    }

    public Optional<OrderDetail> findById(Integer id) {
        return orderDetailRepository.findById(id);
    }

    public void deleteAllInBatch(Iterable<OrderDetail> entities) {
        orderDetailRepository.deleteAllInBatch(entities);
    }

    public boolean existsById(Integer id) {
        return orderDetailRepository.existsById(id);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        orderDetailRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        orderDetailRepository.deleteAllInBatch();
    }

    public OrderDetail getOne(Integer id) {
        return orderDetailRepository.getOne(id);
    }

    public long count() {
        return orderDetailRepository.count();
    }

    public void deleteById(Integer id) {
        orderDetailRepository.deleteById(id);
    }

    public OrderDetail getById(Integer id) {
        return orderDetailRepository.getById(id);
    }

    public void delete(OrderDetail entity) {
        orderDetailRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        orderDetailRepository.deleteAllById(ids);
    }

    public OrderDetail getReferenceById(Integer id) {
        return orderDetailRepository.getReferenceById(id);
    }

    public void deleteAll(Iterable<? extends OrderDetail> entities) {
        orderDetailRepository.deleteAll(entities);
    }

    public void deleteAll() {
        orderDetailRepository.deleteAll();
    }

}
