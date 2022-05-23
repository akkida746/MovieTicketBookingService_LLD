package com.example.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
public class Show {
    private String id;
    private Date start;
    private Date end;
    private Movie movie;
    private Theatre theatre;
    private double price;
    private Set<Seat> seats;
}
