package com.ss.org.cartService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private String brand;
    private String desc;
}
