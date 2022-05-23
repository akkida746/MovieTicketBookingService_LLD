package com.example.booking.model;

import com.example.booking.SeatStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Seat {
    private String id;
    private SeatStatusEnum statusEnum = SeatStatusEnum.EMPTY;
    public Seat(String id){
        this.id = id;
    }
}
