package com.ss.org.cartService.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Cart cart;
    private String phoneNumber;
    private String email;
}
