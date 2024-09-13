package com.manhcode.repository;

import com.manhcode.model.Order;
import com.manhcode.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);

    @Query("SELECT o FROM Order o ORDER BY o.product.price * o.quantity DESC")
    List<Order> findTopOrdersByTotalPrice(Pageable pageable);
}
