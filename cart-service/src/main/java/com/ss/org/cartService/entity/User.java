package com.ss.org.cartService.entity;

import com.ss.org.cartService.model.Cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Cart cart;
    private String phoneNumber;
    private String email;
}
