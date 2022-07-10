package com.ss.org.cartService.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private String message;
    private int errorCode;
    private String cause;
}
