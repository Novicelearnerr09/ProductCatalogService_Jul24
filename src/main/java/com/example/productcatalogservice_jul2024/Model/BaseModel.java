package com.example.productcatalogservice_jul2024.Model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.nimbus.State;
import java.util.Date;
@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long Id;
    private Date createdAt;
    private Date lastUpdatedAt;

   // private State state;
}
