package com.scaler.productservicespk.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    //@Column(unique = true, nullable = false) -- This is yet not taught and will be explained in next class
    private String title;
    private Double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String description;
    private String image;
}
