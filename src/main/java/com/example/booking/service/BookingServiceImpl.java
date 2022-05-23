package com.example.booking.service;

import com.example.booking.SeatStatusEnum;
import com.example.booking.exception.SeatNotAvailableException;
import com.example.booking.exception.ShowNotFoundException;
import com.example.booking.model.*;
import com.example.booking.strategy.IPriceStrategy;
import lombok.Data;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Data
public class BookingServiceImpl implements IBookingService{
    AtomicInteger ticketCounter = new AtomicInteger(0);
    private Set<City> cities = new HashSet<>();
    private Set<Theatre> theatres = new HashSet<>();
    private Set<Show> shows = new HashSet<>();
    private Set<Movie> movies = new HashSet<>();
    private IPriceStrategy priceStrategy;

    public Ticket bookTicket(Theatre theatre, Movie movie, Date date, Set<String> seats){
        Optional<Show> showOptional = shows.stream().filter(show -> show.getTheatre().equals(theatre) && show.getMovie().equals(movie)).findAny();
        if(showOptional.isEmpty() || showOptional.get().getStart().getHours()!=date.getHours()){
            throw new ShowNotFoundException("Show not found for movie: " + movie);
        }
        Show show = showOptional.get();
        Set<Seat> availableSeats = show.getSeats().stream().filter(seat -> seats.contains(seat.getId()) &&
                seat.getStatusEnum().toString().equalsIgnoreCase(SeatStatusEnum.EMPTY.toString())).collect(Collectors.toSet());
        if(availableSeats.size()<seats.size()){
            throw new SeatNotAvailableException("Seat not available for show: " + show);
        }
        return new Ticket(ticketCounter.incrementAndGet(),showOptional.get());
    }

    public Set<Show> getMovieTheater(Movie movie, City city){
        Set<Show> res = shows.stream().filter(show -> show.getMovie().equals(movie) && show.getTheatre().getCity().equals(city))
                .collect(Collectors.toSet());
        return res;
    }
    public double calculatePrice(int ticketCount, int newTicketCount, double pricePerTicket, Show show){
         return priceStrategy.calculate(ticketCount, newTicketCount, pricePerTicket, show);
    }

    public void populateData(Set<City> cities, Set<Theatre> theatres, Set<Show> shows, Set<Movie> movies){
        this.cities = cities;
        this.theatres = theatres;
        this.shows = shows;
        this.movies = movies;
    }
}
