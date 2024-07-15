package com.example.productcatalogservice_jul2024.Dto;

import com.example.productcatalogservice_jul2024.Model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String Description;
    private Long Id;
    private Category category;
    private String imageUrl;
    private Long price;
}
