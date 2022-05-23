package com.example.booking.service;

import com.example.booking.model.Movie;
import com.example.booking.model.Show;
import com.example.booking.model.Theatre;

import java.util.Date;

public interface IThreaterService {
    Show createShow(Theatre theatre, Movie movie, Date start, Date end, double price);
}
