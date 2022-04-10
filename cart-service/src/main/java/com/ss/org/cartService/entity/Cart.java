package com.ss.org.cartService.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name ="CART")
public class Cart {

    @Id
    @GeneratedValue
    private int id;
    private List<Product> product;
    private int productCount;
    private long totalPrice;
}
