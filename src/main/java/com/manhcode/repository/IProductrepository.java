package com.manhcode.repository;

import com.manhcode.model.Product;
import com.manhcode.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductrepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAllByType(Type type);

    Page<Product> findAll(Pageable pageable);
}
