package com.example.booking.service;

import com.example.booking.model.*;

import java.util.Date;
import java.util.Set;

public interface IBookingService {
    void populateData(Set<City> cities, Set<Theatre> theatres, Set<Show> shows, Set<Movie> movies);
    Set<Show> getMovieTheater(Movie movie, City city);
    Ticket bookTicket(Theatre theatre, Movie movie, Date date, Set<String> seats);
}
