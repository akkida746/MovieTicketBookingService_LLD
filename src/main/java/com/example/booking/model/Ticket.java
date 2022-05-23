package com.example.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Ticket {
    private int id;
    private Show show;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", show=" + show +
                '}';
    }
}
