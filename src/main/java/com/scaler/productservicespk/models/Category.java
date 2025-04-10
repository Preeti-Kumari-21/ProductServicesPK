package com.scaler.productservicespk.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{
    private String name;
    private String value;
}
