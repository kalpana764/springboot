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
    private String userId;
    private String name;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Cart cart;
    private String phoneNumber;
    private String email;
}
