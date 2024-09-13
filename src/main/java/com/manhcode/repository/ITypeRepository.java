package com.manhcode.repository;

import com.manhcode.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends CrudRepository<Type, Long> {
}
