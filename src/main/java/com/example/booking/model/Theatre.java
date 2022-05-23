package com.example.booking.model;

import lombok.Data;
import java.util.Objects;
import java.util.Set;

@Data
public class Theatre {
    private String id;
    private String name;
    private String address;
    private City city;
    public Theatre(String id,String name, City city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return Objects.equals(id, theatre.id) && Objects.equals(name, theatre.name) && Objects.equals(address, theatre.address) && Objects.equals(city, theatre.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, city);
    }
}
