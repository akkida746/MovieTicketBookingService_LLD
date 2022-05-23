package com.example.booking.service;

import com.example.booking.model.Customer;
import com.example.booking.model.Ticket;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class CustomerServiceImpl implements ICustomerService{
    private Set<Customer> customers = new HashSet<>();
    private Map<Customer,Set<Ticket>> customerTicketMap = new HashMap<>();

    public Set<Ticket> getCustomerTickets(Customer customer){
        return customerTicketMap.get(customer);
    }
}
