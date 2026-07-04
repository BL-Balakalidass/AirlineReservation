package service;

import model.Flight;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlightManager {

    // ---------------------------------------
    // Singleton Instance
    // ---------------------------------------

    private static FlightManager instance;

    // ---------------------------------------
    // Flight Cache
    // ---------------------------------------

    private Map<String, Flight> flightCache;

    // ---------------------------------------
    // Private Constructor
    // ---------------------------------------

    private FlightManager() {

        flightCache = new HashMap<>();

    }

    // ---------------------------------------
    // Get Singleton Instance
    // ---------------------------------------

    public static synchronized FlightManager getInstance() {

        if (instance == null) {

            instance = new FlightManager();

        }

        return instance;

    }

    // ---------------------------------------
    // Add Flight
    // ---------------------------------------

    public void addFlight(Flight flight) {

        if (flight == null) {

            System.out.println("Invalid Flight.");

            return;

        }

        flightCache.put(
                flight.getFlightNumber(),
                flight
        );

        System.out.println("Flight Added : "
                + flight.getFlightNumber());

    }

    // ---------------------------------------
    // Get Flight
    // ---------------------------------------

    public Flight getFlight(String flightNumber) {

        return flightCache.get(flightNumber);

    }

    // ---------------------------------------
    // Remove Flight
    // ---------------------------------------

    public void removeFlight(String flightNumber) {

        if (flightCache.remove(flightNumber) != null) {

            System.out.println("Flight Removed : "
                    + flightNumber);

        } else {

            System.out.println("Flight Not Found.");

        }

    }

    // ---------------------------------------
    // Flight Exists
    // ---------------------------------------

    public boolean containsFlight(String flightNumber) {

        return flightCache.containsKey(flightNumber);

    }

    // ---------------------------------------
    // Total Flights
    // ---------------------------------------

    public int getFlightCount() {

        return flightCache.size();

    }

    // ---------------------------------------
    // Get All Flights
    // ---------------------------------------

    public Collection<Flight> getAllFlights() {

        return flightCache.values();

    }

    // ---------------------------------------
    // Display Flights
    // ---------------------------------------

    public void displayFlights() {

        System.out.println();

        System.out.println("========== FLIGHTS ==========");

        if (flightCache.isEmpty()) {

            System.out.println("No Flights Available.");

            return;

        }

        for (Flight flight : flightCache.values()) {

            System.out.println("--------------------------------");

            System.out.println("Flight Number : "
                    + flight.getFlightNumber());

            System.out.println("Fare : ₹"
                    + flight.getFare());

            System.out.println("Available Seats : "
                    + flight.getAvailableSeats());

            System.out.println("Status : "
                    + flight.getStatus());

        }

    }

    // ---------------------------------------
    // Clear Cache
    // ---------------------------------------

    public void clearFlights() {

        flightCache.clear();

        System.out.println("Flight Cache Cleared.");

    }

}