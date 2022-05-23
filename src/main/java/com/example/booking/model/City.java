package com.example.booking.model;

import lombok.Data;

@Data
public class City {
    private String id;
    private String name;
    private String State;
    private String country;
    public City(String id,String name){
        this.id = id;
        this.name = name;
    }
}
