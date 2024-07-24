package com.example.productcatalogservice_jul2024.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product  extends BaseModel{
   // private boolean isPrime;
    private String name;
    private Long price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
        private String ImageUrl;

}
