package com.ss.org.cartService.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
@Builder(setterPrefix = "with")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private String productId;
    private String name;
    private int price;
    private String brand;
    private String desc;

    @ManyToOne
    @JoinColumn(referencedColumnName = "cartId")
    private Cart cart;
}
