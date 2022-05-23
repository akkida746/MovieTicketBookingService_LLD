package com.example.booking.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException(String msg){
        super(msg);
    }
}
