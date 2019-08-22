package com.kodilla.exception.test;

public class RouteNotFoundExceptionRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("WAW","GDN");
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        try {
            flightSearchEngine.findFilght(flight);
        }catch (RouteNotFoundException e){
            System.out.println("Exception: "+ e);
        }
    }
}