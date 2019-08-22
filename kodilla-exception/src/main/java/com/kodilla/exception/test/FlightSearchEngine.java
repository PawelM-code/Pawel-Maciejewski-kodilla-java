package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearchEngine {
    public boolean findFilght(Flight flight)throws RouteNotFoundException{
        Map<String, Boolean> airportMap = new HashMap<>();
        airportMap.put("WAW",true);
        airportMap.put("KRK",true);
        airportMap.put("GDN",false);
        airportMap.put("WRO",false);
        airportMap.put("KTW",true);

        List<Boolean> flightStatusList = new ArrayList<>();
        boolean flightStatus = true;

        if(airportMap.containsKey(flight.getArrivalAirport()) &&
                airportMap.containsKey(flight.getDepartureAirport())) {
            airportMap.entrySet()
                    .forEach(pair -> {
                        if (pair.getKey().equals(flight.getDepartureAirport()) ||
                                pair.getKey().equals(flight.getArrivalAirport())) {
                            if(!pair.getValue()) flightStatusList.add(false);
                        }
                    });
        }else {
            throw new RouteNotFoundException("Incorrect flight. The airport does not exist.");
        }

        if (flightStatusList.size()>0) flightStatus = false;
        return flightStatus;
    }
}
