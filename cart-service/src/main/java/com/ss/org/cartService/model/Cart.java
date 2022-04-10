package com.ss.org.cartService.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private List<Product> product;
    private int productCount;
    private long totalPrice;
}
