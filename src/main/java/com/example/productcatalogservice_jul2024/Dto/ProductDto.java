package com.example.productcatalogservice_jul2024.Dto;

import com.example.productcatalogservice_jul2024.Model.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
  //  private boolean isPrime;

    private String name;
    private String Description;
    private Long Id;
    private Category category;
    private String imageUrl;
    private Long price;
}
