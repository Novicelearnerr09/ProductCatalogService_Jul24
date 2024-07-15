package com.example.productcatalogservice_jul2024.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private String title;
    private Long id;
    private String description;
    private String image;
    private String category;
    private Long price;
    private FakeStoreRatingDto fakeStoreRatingDto;
}
