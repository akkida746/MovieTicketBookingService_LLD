package com.example.booking;

import com.example.booking.model.*;
import com.example.booking.service.BookingServiceImpl;
import com.example.booking.service.IBookingService;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingApplication {
	private static IBookingService bookingService = new BookingServiceImpl();

	public static void main(String[] args) {
		populateData();
		Movie movie = new Movie("m1","m1");
		City city = new City("city1","city1");
		Set<Show> shows = bookingService.getMovieTheater(movie, city);
		for(Show show: shows){
			System.out.println(show.getTheatre().getName() + ", " + show.getTheatre().getCity().getName());
		}

		// Booking tickets
		System.out.println("Booking tickets..");
		Date date = new Date();
		date.setHours(17);
		Show show = shows.stream().findFirst().get();
		Set<String> seats = new HashSet<>();
		seats.add("s1");
		Ticket ticket = bookingService.bookTicket(show.getTheatre(), movie, date, seats);
		System.out.println(ticket);
	}
	static void populateData(){
		Set<City> cities = new HashSet<>();
		Set<Theatre> theatres= new HashSet<>();
		Set<Movie> movies = new HashSet<>();
		Set<Show> shows = new HashSet<>();
		Set<Seat> seats = new HashSet<>();

		for(int i=1;i<10;i++){
			seats.add(new Seat("s"+1));
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		City city1 = new City("city1","city1");
		City city2 = new City("city2","city2");
		cities.add(city1);
		cities.add(city2);

		Theatre t1 = new Theatre("t1","t1", city1);
		Theatre t2 = new Theatre("t2", "t2",city1);
		Theatre t3 = new Theatre("t3","t3", city2);
		Theatre t4 = new Theatre("t4", "t4",city2);
		theatres.add(t1);
		theatres.add(t2);
		theatres.add(t3);
		theatres.add(t4);

		Movie m1 = new Movie("m1","m1");
		Movie m2 = new Movie("m2","m2");
		Movie m3 = new Movie("m3","m3");
		Movie m4 = new Movie("m4","m4");
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);

		Date start = new Date();
		Date end = new Date();
		start.setHours(11);
		end.setHours(14);
		Show show1 = new Show("show1",start,end,m1, t1,100.00, seats);
		start.setHours(12);
		end.setHours(15);
		Show show2 = new Show("show2",start,end,m1, t1,100.00, seats);
		start.setHours(13);
		end.setHours(16);
		Show show3 = new Show("show3",start,end,m2, t2,100.00, seats);
		start.setHours(17);
		end.setHours(20);
		Show show4 = new Show("show4",start,end,m2, t2,100.00, seats);
		shows.add(show1);
		shows.add(show2);
		shows.add(show3);
		shows.add(show4);

		Customer c1 = new Customer("c1");
		Customer c2 = new Customer("c2");
		bookingService.populateData(cities,theatres,shows,movies);
	}
}
