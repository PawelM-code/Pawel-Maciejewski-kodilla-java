package com.kodilla.good.patterns.flights;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class FlightListRetriever {
    private Airport waw = new Airport("WAW");
    private Airport krk = new Airport("KRK");
    private Airport ktw = new Airport("KTW");

    ArrayList<Airport> getAvailableAirports() {
        ArrayList<Airport> airportList = new ArrayList<>();
        airportList.add(waw);
        airportList.add(krk);
        airportList.add(ktw);

        return airportList;
    }

    Map<Airport, ArrayList<Flight>> retrieve() {
        ArrayList<Flight> warszawa = new ArrayList<>();
        warszawa.add(new Flight(krk, LocalDateTime.of(2019, 9, 29, 10, 0)));
        warszawa.add(new Flight(ktw, LocalDateTime.of(2019, 9, 29, 18, 0)));
        warszawa.add(new Flight(ktw, LocalDateTime.of(2019, 9, 29, 23, 0)));

        ArrayList<Flight> krakow = new ArrayList<>();
        krakow.add(new Flight(waw, LocalDateTime.of(2019, 9, 29, 11, 0)));
        krakow.add(new Flight(waw, LocalDateTime.of(2019, 9, 29, 13, 0)));

        ArrayList<Flight> katowice = new ArrayList<>();
        katowice.add(new Flight(waw, LocalDateTime.of(2019, 9, 29, 14, 0)));
        katowice.add(new Flight(krk, LocalDateTime.of(2019, 9, 29, 6, 0)));

        Map<Airport, ArrayList<Flight>> flightList = new HashMap<>();
        flightList.put(waw, warszawa);
        flightList.put(krk, krakow);
        flightList.put(ktw, katowice);

        return flightList;
    }
}
