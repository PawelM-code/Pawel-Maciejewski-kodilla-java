package com.kodilla.good.patterns.flights;

class UserDialogCore {
    private SearchInformationService searchInformationService = new SearchInformationService();

    void userDialogAction(String airportNameOne, String airportNameTwo, String searchOption) {
        if (searchInformationService.showIsAirportNameIncorrect(airportNameOne)) {
            if (Integer.valueOf(searchOption) == 1) {
                searchInformationService.showAllFlightsFromAirport(airportNameOne);
            } else if (Integer.valueOf(searchOption) == 2) {
                searchInformationService.showAllFlightsToAirportWithoutTransfer(airportNameOne);
            } else {
                searchInformationService.showAllFlightsToAirportWithTransfer(airportNameOne, airportNameTwo);
            }
        }
    }

}
