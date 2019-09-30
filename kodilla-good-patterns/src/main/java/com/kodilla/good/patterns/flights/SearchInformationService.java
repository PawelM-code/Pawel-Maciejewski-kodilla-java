package com.kodilla.good.patterns.flights;

class SearchInformationService {
    private FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

    void showTravelDirections() {
        System.out.println("Available travel directions are: WAW, KRK, KTW.\n");
    }

    void showSearchOptions() {
        System.out.println("Key 1 - search for all flights from the airport. \n" +
                "Key 2 - search for all flights to the airport. \n" +
                "Key 3 - search for all flights to the airport with a transfer by another airport.\n" +
                "Enter Key: ");
    }

    void showHowToEnterAirportName(int searchOption) {
        if (searchOption == 1 || searchOption == 2) {
            System.out.println("Enter airport name e.g WAW: ");
        } else if (searchOption == 3) {
            System.out.println("Enter airport names e.g. WAW (first transfer airport, next destination airport): ");
        } else {
            System.out.println("Invalid key.");
            System.exit(0);
        }
    }

    boolean showIsAirportNameIncorrect(String airport) {
        Airport airportToCheck = new Airport(airport);
        FlightListRetriever flightListRetriever = new FlightListRetriever();
        if (!flightListRetriever.getAvailableAirports().contains(airportToCheck)) {
            System.out.println("Invalid airport name.");
            return false;
        } else {
            return true;
        }
    }

    void showAllFlightsFromAirport(String airport) {
        flightSearchEngine.searchAllFlightsFromAirport(new Airport(airport))
                .forEach(a -> System.out.println(airport + " -> " + a.getAirport().getCity() + " " + a.getDepartureDate()));
    }

    void showAllFlightsToAirportWithoutTransfer(String airport) {
        flightSearchEngine.searchAllFlightsToAirportWithoutTransfer(new Airport(airport))
                .forEach((key, value) -> value
                        .forEach(v -> System.out.println(key.getCity() + " -> " + v.getAirport().getCity() + " " + v.getDepartureDate())));
        System.out.println();
    }

    void showAllFlightsToAirportWithTransfer(String transferAirport, String destinationAirport) {
        flightSearchEngine.searchAllFlightsToAirportWithTransfer(new Airport(transferAirport), new Airport(destinationAirport))
                .forEach((key, value) ->
                        value.forEach(entry ->
                                entry.forEach((k, v) -> {
                                    System.out.println(key.getCity() + " -> " + k.getAirport().getCity() + " " + k.getDepartureDate());
                                    v.forEach(flight -> System.out.println(k.getAirport().getCity() + " -> " + flight.getAirport().getCity() + " " + flight.getDepartureDate()));
                                })));
    }
}
