package com.manhcode.service.order;

import com.manhcode.model.Order;
import com.manhcode.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IGenerateService<Order> {
    Page<Order> findAll(Pageable pageable);

}
