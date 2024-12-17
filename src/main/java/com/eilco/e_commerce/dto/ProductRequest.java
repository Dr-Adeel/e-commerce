package com.eilco.e_commerce.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private boolean active;
    private String imageUrl;
}
