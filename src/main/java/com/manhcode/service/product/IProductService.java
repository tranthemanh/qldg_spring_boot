package com.manhcode.service.product;

import com.manhcode.model.Product;
import com.manhcode.model.Type;
import com.manhcode.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGenerateService<Product> {
    Iterable<Product> findAllByType(Type type);

    Page<Product> findAll(Pageable pageable);
}
