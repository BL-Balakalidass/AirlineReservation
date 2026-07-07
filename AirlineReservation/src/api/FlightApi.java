package api;

import model.Flight;
import service.FlightManagementService;

import java.time.LocalDate;
import java.util.List;

public class FlightApi {

    private FlightManagementService flightService;

    public FlightApi(
            FlightManagementService flightService) {

        this.flightService = flightService;

    }

    // =====================================================
    // SEARCH ALL FLIGHTS
    // =====================================================

    public List<Flight> searchFlights() {

        System.out.println("\n========== FLIGHT SEARCH API ==========");

        return flightService.getAllFlights();

    }

    // =====================================================
    // SEARCH BY AIRLINE
    // =====================================================

    public List<Flight> searchByAirline(
            String airline) {

        System.out.println("\nSearching Airline : " + airline);

        return flightService.searchFlightsByAirline(
                airline);

    }

    // =====================================================
    // SEARCH BY ROUTE
    // =====================================================

    public List<Flight> searchByRoute(
            String source,
            String destination) {

        System.out.println(
                "\nSearching Route : "
                        + source
                        + " -> "
                        + destination);

        return flightService.filterByRoute(
                source,
                destination);

    }

    // =====================================================
    // SEARCH BY DATE
    // =====================================================

    public List<Flight> searchByDate(
            LocalDate date) {

        System.out.println(
                "\nSearching Date : "
                        + date);

        return flightService.searchFlightsByDate(
                date);

    }

}