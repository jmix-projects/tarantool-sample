package com.company.sample.entity;

import com.company.sample.dto.Product;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import java.util.UUID;

/**
 * Jmix DTO entity to de displayed in Jmix screen. Works together with {@link Product} that is a tarantool tuple.
 * <p>
 * We can't use the same class both as Jmix and Tarantool DTO because Jmix entity hase some service fields that should
 * not be mapped to Tarantool tuples (e.g. _entityEntry).
 */
@JmixEntity
public class ProductModel {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    @InstanceName
    private String name;

    private String description;

    public static ProductModel fromTarantoolProduct(Product product) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setDescription(product.getDescription());
        return productModel;
    }

    public Product toTarantoolProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        return product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}