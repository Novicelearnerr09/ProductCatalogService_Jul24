package com.example.productcatalogservice_jul2024.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseModel{
    private String name;
    private String description;
   @OneToMany(mappedBy = "category", fetch= FetchType.LAZY)
   @Fetch(FetchMode.SELECT)
   @BatchSize(size=3)
   //BATCHSIZE  : remove N+1 problem
    private List<Product> productList = new ArrayList<>();
 //  private State state;
}
//2nd commit from earth
