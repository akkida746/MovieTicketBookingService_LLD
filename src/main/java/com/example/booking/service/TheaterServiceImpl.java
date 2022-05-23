package com.example.booking.service;

import com.example.booking.model.Movie;
import com.example.booking.model.Seat;
import com.example.booking.model.Show;
import com.example.booking.model.Theatre;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TheaterServiceImpl implements IThreaterService{
    private AtomicInteger showCounter = new AtomicInteger(1);
    public Show createShow(Theatre theatre, Movie movie, Date start, Date end, double price){
        Set<Seat> seats = new HashSet<>();
        for(int i=1;i<10;i++){
            seats.add(new Seat("s"+1));
        }
        Show show = new Show("s"+showCounter.incrementAndGet(), start, end, movie, theatre, price, seats);
        return show;
    }
}
