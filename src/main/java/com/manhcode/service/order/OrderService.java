package com.manhcode.service.order;

import com.manhcode.model.Order;
import com.manhcode.model.Product;
import com.manhcode.repository.IOrderRepository;
import com.manhcode.repository.IProductrepository;
import com.manhcode.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IProductrepository productRepository;

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Đơn hàng không tìm thấy"));
    }

    public void updateOrder(Long orderId, Long productId, Date purchaseDate, int quantity) {
        Order order = getOrderById(orderId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Sản phẩm không tìm thấy"));
        order.setProduct(product);
        order.setDate(purchaseDate);
        order.setQuantity(quantity);
        orderRepository.save(order);
    }

    public List<Order> getTop5HighestTotalOrders() {
        Pageable topFive = PageRequest.of(0, 5);
        return orderRepository.findTopOrdersByTotalPrice(topFive);
    }

}
