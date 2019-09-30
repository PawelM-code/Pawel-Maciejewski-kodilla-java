package com.kodilla.good.patterns.flights;

public class Airport {
    private String city;

    Airport(String city) {
        this.city = city;
    }

    String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        return city != null ? city.equals(airport.city) : airport.city == null;
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}
