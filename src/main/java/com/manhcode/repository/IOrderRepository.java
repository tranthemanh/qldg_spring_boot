package com.manhcode.repository;

import com.manhcode.model.Order;
import com.manhcode.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);
}
