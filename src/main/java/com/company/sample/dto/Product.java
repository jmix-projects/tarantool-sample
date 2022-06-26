package com.company.sample.dto;

import org.springframework.data.tarantool.core.mapping.Field;
import org.springframework.data.tarantool.core.mapping.Tuple;

import java.util.UUID;

/**
 * DTO represents a tuple from Tarantool "products" space.
 */
@Tuple("products")
public class Product {
    @Field("product_id")
    private UUID id;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

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