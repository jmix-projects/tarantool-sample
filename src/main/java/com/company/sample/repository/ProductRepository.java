package com.company.sample.repository;

import com.company.sample.dto.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository for working with records from Tarantool "products" space.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
