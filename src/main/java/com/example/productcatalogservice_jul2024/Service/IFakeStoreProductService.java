package com.example.productcatalogservice_jul2024.Service;

import com.example.productcatalogservice_jul2024.Model.Product;

import java.util.List;

public interface IFakeStoreProductService {
    Product getProductById(Long Id);

    List<Product> getAllProducts();

    Product createProduct();

    Product replaceProduct(Long id, Product product);
}
