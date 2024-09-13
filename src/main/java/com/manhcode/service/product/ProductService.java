package com.manhcode.service.product;

import com.manhcode.model.Product;
import com.manhcode.model.Type;
import com.manhcode.repository.IProductrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductrepository iProductrepository;

    @Override
    public Iterable<Product> findAllByType(Type type) {
        return iProductrepository.findAllByType(type);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductrepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findAll() {
        return iProductrepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductrepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductrepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProductrepository.deleteById(id);
    }
}
