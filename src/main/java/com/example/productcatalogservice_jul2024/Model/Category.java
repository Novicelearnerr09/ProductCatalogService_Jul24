package com.example.productcatalogservice_jul2024.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    private String description;
   @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();
 //  private State state;
}
//2nd commit from earth
