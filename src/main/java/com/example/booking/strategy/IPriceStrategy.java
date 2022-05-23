package com.example.booking.strategy;

import com.example.booking.model.Show;

public interface IPriceStrategy {
    double calculate(int ticketCount, int newTicketsCount, double ticketPrice, Show show);
}
