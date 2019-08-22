package com.kodilla.exception.test;

public class RouteNotFoundExceptionRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("WAW","AAA");
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        try {
            if(flightSearchEngine.findFilght(flight)) {
                System.out.println("Found a flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport());
            }else {
                System.out.println("Flight route not found.");
            }
        }catch (RouteNotFoundException e){
            System.out.println("Exception: "+ e);
        }
    }
}