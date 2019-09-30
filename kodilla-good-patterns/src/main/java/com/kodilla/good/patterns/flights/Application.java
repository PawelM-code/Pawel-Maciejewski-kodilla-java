package com.kodilla.good.patterns.flights;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchInformationService searchInformationService = new SearchInformationService();
        searchInformationService.showTravelDirections();
        searchInformationService.showSearchOptions();

        String searchOption = scanner.nextLine();
        searchInformationService.showHowToEnterAirportName(Integer.valueOf(searchOption));

        String airportNameOne;
        String airportNameTwo = null;
        if(Integer.valueOf(searchOption) == 1 || Integer.valueOf(searchOption) == 2){
            airportNameOne = scanner.nextLine();
        }else {
            airportNameOne = scanner.nextLine();
            airportNameTwo = scanner.nextLine();
        }

        UserDialogCore userDialogCore = new UserDialogCore();
        userDialogCore.userDialogAction(airportNameOne,airportNameTwo,searchOption);
    }
}
