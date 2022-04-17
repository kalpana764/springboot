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
    @OneToMany(mappedBy = "product")
    private String id;
    private String name;
    private int price;
    private String brand;
    private String desc;
}
