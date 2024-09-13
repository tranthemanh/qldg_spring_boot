package com.manhcode.service.order;

import com.manhcode.model.Order;
import com.manhcode.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }

    @Override
    public Iterable<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return iOrderRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iOrderRepository.deleteById(id);
    }
}
