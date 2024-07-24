package com.example.productcatalogservice_jul2024.Controller;


import com.example.productcatalogservice_jul2024.Dto.CategoryDto;
import com.example.productcatalogservice_jul2024.Dto.ProductDto;
import com.example.productcatalogservice_jul2024.Model.Category;
import com.example.productcatalogservice_jul2024.Model.Product;
import com.example.productcatalogservice_jul2024.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<ProductDto> results = new ArrayList<>();//1
        List<Product> products = iProductService.getAllProducts();//2
        for(Product product : products) {
            results.add(getProductDto(product));//3
        }

        return results;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId) {
        try {
        if (productId <= 0) {
            throw new IllegalArgumentException("invalid productId");
        }

        Product product = iProductService.getProductById(productId);
        ProductDto body = getProductDto(product);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("called by", "anurag");
        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    } catch(IllegalArgumentException ex) {
        throw ex;
        //return handleExceptions(ex);
        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
        Product result = iProductService.createProduct(product);
        return getProductDto(result);
    }


    @PutMapping("/{id}")
    public ProductDto replaceProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
        Product newProduct = iProductService.replaceProduct(id,product);
        return getProductDto(newProduct);//commit
    }

    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDescription(product.getCategory().getDescription());
            categoryDto.setId(product.getCategory().getId());
            productDto.setCategory(product.getCategory());
        }
        return productDto;
    }
}