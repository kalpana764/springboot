package com.ss.org.cartService.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="USER")
@Getter
@Setter
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Cart cart;
    
    
}
