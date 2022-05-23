package com.example.booking.strategy;

import com.example.booking.model.Show;
import java.util.Date;

public class TicketPriceStrategy implements IPriceStrategy{
    public double calculate(int ticketCount, int newTicketsCount, double ticketPrice, Show show){
        double sum = ticketCount*ticketPrice + ticketPrice;
        if(ticketCount%2==0){
            newTicketsCount--;
            sum = ticketCount*ticketPrice + (ticketPrice-.50*ticketPrice) + newTicketsCount*ticketPrice;
        }

        Date start = show.getStart();
        if(start.getHours()>=12 && start.getHours()<=3){
            sum = sum - (.20*sum);
        }

        return sum;
    }
}
