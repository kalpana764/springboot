package com.ss.org.cartService.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="CART")
@Builder(setterPrefix = "with")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private String cartId;
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<Product> product;
    private int productCount;
    private long totalPrice;
    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private User user;
}
