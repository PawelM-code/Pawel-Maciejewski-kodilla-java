package com.kodilla.good.patterns.flights;

import java.time.LocalDateTime;

class Flight {
    private Airport airport;
    private LocalDateTime departureDate;

    Flight(Airport airport, LocalDateTime departureDate) {
        this.airport = airport;
        this.departureDate = departureDate;
    }

    Airport getAirport() {
        return airport;
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }
}
