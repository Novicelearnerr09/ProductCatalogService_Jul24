package com.example.productcatalogservice_jul2024.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product  extends BaseModel{
    private String name;
    private Long price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
        private String ImageUrl;

}
