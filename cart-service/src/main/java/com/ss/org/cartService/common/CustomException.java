package com.ss.org.cartService.common;

public class CustomException extends RuntimeException{

    private int code;

    public CustomException(String message){
       super(message);
    }
    public CustomException(String message, int code){
        super(message);
        this.code = code;
    }

    public CustomException(String message,Throwable cause, int code){
        super(message,cause);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }



}
