package repository;

import model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightRepository {

    private final List<Flight> flights;

    public FlightRepository() {
        flights = new ArrayList<>();
    }

    /**
     * Add a single flight.
     */
    public void addFlight(Flight flight) {

        if (flight != null) {
            flights.add(flight);
        }
    }

    /**
     * Add multiple flights.
     */
    public void addFlights(List<Flight> flightList) {

        if (flightList != null) {
            flights.addAll(flightList);
        }
    }

    /**
     * Get all flights.
     */
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    /**
     * Find flight by flight number.
     */
    public Optional<Flight> findByFlightNumber(String flightNumber) {

        return flights.stream()
                .filter(flight ->
                        flight.getFlightNumber()
                                .equalsIgnoreCase(flightNumber))
                .findFirst();
    }

    /**
     * Search by source airport code.
     */
    public List<Flight> findBySource(String sourceCode) {

        return flights.stream()
                .filter(flight ->
                        flight.getSourceAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(sourceCode))
                .collect(Collectors.toList());
    }

    /**
     * Search by destination airport code.
     */
    public List<Flight> findByDestination(String destinationCode) {

        return flights.stream()
                .filter(flight ->
                        flight.getDestinationAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(destinationCode))
                .collect(Collectors.toList());
    }

    /**
     * Search by source city.
     */
    public List<Flight> findBySourceCity(String city) {

        return flights.stream()
                .filter(flight ->
                        flight.getSourceAirport()
                                .getCity()
                                .equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    /**
     * Search by destination city.
     */
    public List<Flight> findByDestinationCity(String city) {

        return flights.stream()
                .filter(flight ->
                        flight.getDestinationAirport()
                                .getCity()
                                .equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    /**
     * Search by airline.
     */
    public List<Flight> findByAirline(String airlineName) {

        return flights.stream()
                .filter(flight ->
                        flight.getAirline()
                                .getAirlineName()
                                .equalsIgnoreCase(airlineName))
                .collect(Collectors.toList());
    }

    /**
     * Update flight.
     */
    public boolean updateFlight(Flight updatedFlight) {

        for (int i = 0; i < flights.size(); i++) {

            Flight current = flights.get(i);

            if (current.getFlightNumber()
                    .equalsIgnoreCase(updatedFlight.getFlightNumber())) {

                flights.set(i, updatedFlight);
                return true;
            }
        }

        return false;
    }

    /**
     * Delete flight.
     */
    public boolean deleteFlight(String flightNumber) {

        Optional<Flight> flight =
                findByFlightNumber(flightNumber);

        if (flight.isPresent()) {

            flights.remove(flight.get());
            return true;
        }

        return false;
    }

    /**
     * Total flights.
     */
    public int getFlightCount() {
        return flights.size();
    }

    /**
     * Check if repository is empty.
     */
    public boolean isEmpty() {
        return flights.isEmpty();
    }

    /**
     * Remove all flights.
     */
    public void clear() {
        flights.clear();
    }

    /**
     * Display all flights.
     */
    public void displayAllFlights() {

        if (flights.isEmpty()) {

            System.out.println("No Flights Available.");
            return;
        }

        System.out.println("\n=========== AVAILABLE FLIGHTS ===========");

        flights.forEach(System.out::println);
    }

}