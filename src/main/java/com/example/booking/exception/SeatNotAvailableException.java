package com.example.booking.exception;

public class SeatNotAvailableException extends RuntimeException{
    public SeatNotAvailableException(String msg){
        super(msg);
    }
}
