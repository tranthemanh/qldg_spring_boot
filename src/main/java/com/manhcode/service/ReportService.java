package com.manhcode.service;

import com.manhcode.model.Order;
import com.manhcode.model.Product;
import com.manhcode.model.Type;
import com.manhcode.model.dto.OrderDTO;
import com.manhcode.repository.IOrderRepository;
import com.manhcode.repository.IProductrepository;
import com.manhcode.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Autowired
    private IProductrepository iProductrepository;

    @Autowired
    private ITypeRepository iTypeRepository;

    public Page<OrderDTO> getReport(Pageable pageable) {
        Page<Order> orders = iOrderRepository.findAll(pageable);
        return orders.map(order -> {
            Product product = order.getProduct();
            Type type = product != null ? iTypeRepository.findById(product.getType().getId()).orElse(null) : null;

            if (product != null && type != null) {
                return new OrderDTO(
                        order.getId(),
                        product.getName(),
                        product.getPrice(),
                        type.getName(),
                        order.getDate(),
                        order.getQuantity(),
                        product.getPrice() * order.getQuantity()
                );
            }
            return null;
        });
    }


}
