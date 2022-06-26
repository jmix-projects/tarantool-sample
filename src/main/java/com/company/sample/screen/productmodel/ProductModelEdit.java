package com.company.sample.screen.productmodel;

import com.company.sample.dto.Product;
import com.company.sample.repository.ProductRepository;
import io.jmix.core.SaveContext;
import io.jmix.ui.screen.*;
import com.company.sample.entity.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@UiController("ProductModel.edit")
@UiDescriptor("product-model-edit.xml")
@EditedEntityContainer("productModelDc")
public class ProductModelEdit extends StandardEditor<ProductModel> {

    @Autowired
    private ProductRepository productRepository;

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        ProductModel productModel = getEditedEntity();
        Product product = productModel.toTarantoolProduct();
        Product savedProduct = productRepository.save(product);
        return Set.of(ProductModel.fromTarantoolProduct(savedProduct));
    }
}