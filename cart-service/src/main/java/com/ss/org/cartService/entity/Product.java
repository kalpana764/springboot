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
    private Long productId;
    private String name;
    private int price;
    private String brand;
    private String desc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
