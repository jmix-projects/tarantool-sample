package com.company.sample.screen.productmodel;

import com.company.sample.dto.Product;
import com.company.sample.repository.ProductRepository;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.sample.entity.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@UiController("ProductModel.browse")
@UiDescriptor("product-model-browse.xml")
@LookupComponent("productModelsTable")
public class ProductModelBrowse extends StandardLookup<ProductModel> {

    @Autowired
    private ProductRepository productRepository;

    @Install(to = "productModelsDl", target = Target.DATA_LOADER)
    private List<ProductModel> productModelsDlLoadDelegate(LoadContext<ProductModel> loadContext) {
        Iterable<Product> products = productRepository.findAll();
        List<ProductModel> productModels = StreamSupport.stream(products.spliterator(), false)
                .map(ProductModel::fromTarantoolProduct)
                .toList();
        return productModels;
    }
}