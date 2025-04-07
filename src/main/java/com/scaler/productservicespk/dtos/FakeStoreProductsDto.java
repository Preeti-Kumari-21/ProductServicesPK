package com.scaler.productservicespk.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductsDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
}
