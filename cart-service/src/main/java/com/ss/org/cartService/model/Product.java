package com.ss.org.cartService.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private int price;
    private String brand;
    private String desc;
}
