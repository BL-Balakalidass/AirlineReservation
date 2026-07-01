package service;

import model.Flight;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSortService {

    /**
     * Sort flights by price (Low → High)
     */
    public List<Flight> sortByPriceLowToHigh(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparingDouble(Flight::getTotalFare))
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by price (High → Low)
     */
    public List<Flight> sortByPriceHighToLow(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparingDouble(Flight::getTotalFare)
                        .reversed())
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by duration (Shortest First)
     */
    public List<Flight> sortByDuration(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparing(
                        Flight::getFlightDuration))
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by departure time.
     */
    public List<Flight> sortByDepartureTime(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparing(
                        Flight::getDepartureTime))
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by arrival time.
     */
    public List<Flight> sortByArrivalTime(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparing(
                        Flight::getArrivalTime))
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by airline name.
     */
    public List<Flight> sortByAirline(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparing(
                        flight -> flight.getAirline().getAirlineName()))
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by available seats.
     */
    public List<Flight> sortByAvailableSeats(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparingInt(
                                Flight::getAvailableSeats)
                        .reversed())
                .collect(Collectors.toList());
    }

    /**
     * Sort flights by flight number.
     */
    public List<Flight> sortByFlightNumber(List<Flight> flights) {

        return flights.stream()
                .sorted(Comparator.comparing(
                        Flight::getFlightNumber))
                .collect(Collectors.toList());
    }

    /**
     * Display flights after sorting.
     */
    public void displayFlights(List<Flight> flights) {

        if (flights == null || flights.isEmpty()) {

            System.out.println("No Flights Found.");
            return;
        }

        flights.forEach(System.out::println);
    }

}