package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class FlightSearchEngine {
    private FlightListRetriever flightListRetriever = new FlightListRetriever();

    ArrayList<Flight> searchAllFlightsFromAirport(Airport airport) {
        ArrayList<Flight> airportDepartures = new ArrayList<>();

        flightListRetriever.retrieve()
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(airport))
                .forEach(v -> airportDepartures.addAll(v.getValue()));

        return airportDepartures;
    }

    Map<Airport, ArrayList<Flight>> searchAllFlightsToAirportWithoutTransfer(Airport airport) {
        Map<Airport, ArrayList<Flight>> flightsToAirport = new HashMap<>();

        flightListRetriever.retrieve()
                .entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(airport))
                .forEach(e -> {
                    ArrayList<Flight> tempFlightList = new ArrayList<>();
                    e.getValue().forEach(a -> {
                        if (a.getAirport().equals(airport)) tempFlightList.add(a);
                    });
                    if (tempFlightList.size() > 0) flightsToAirport.put(e.getKey(), tempFlightList);
                });

        return flightsToAirport;
    }

    Map<Airport, ArrayList<Map<Flight, ArrayList<Flight>>>> searchAllFlightsToAirportWithTransfer(Airport transferAirport, Airport destinationAirport) {
        Map<Airport, ArrayList<Map<Flight, ArrayList<Flight>>>> flightsToAirportWithTransfer = new HashMap<>();
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        flightSearchEngine.searchAllFlightsToAirportWithoutTransfer(transferAirport)
                .entrySet()
                .stream()
                .filter(e -> !e.getKey().equals(destinationAirport))
                .forEach(entry -> {
                    ArrayList<Map<Flight, ArrayList<Flight>>> tempMapList = new ArrayList<>();
                    entry.getValue()
                            .forEach(v -> {
                                ArrayList<Flight> tempFlightList = new ArrayList<>();
                                flightSearchEngine.searchAllFlightsFromAirport(v.getAirport())
                                        .forEach(flight -> {
                                            if (flight.getAirport().equals(destinationAirport) &&
                                                    v.getDepartureDate().compareTo(flight.getDepartureDate()) < 0) {
                                                tempFlightList.add(flight);
                                            }
                                        });
                                Map<Flight, ArrayList<Flight>> tempMap = new HashMap<>();
                                tempMap.put(v, tempFlightList);
                                tempMapList.add(tempMap);
                            });
                    flightsToAirportWithTransfer.put(entry.getKey(), tempMapList);
                });

        return flightsToAirportWithTransfer;
    }
}
