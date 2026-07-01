package service;

import enums.TravelClass;
import model.Flight;
import repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {

    private final FlightRepository repository;

    /**
     * Constructor
     */
    public FlightSearchService(FlightRepository repository) {
        this.repository = repository;
    }

    /**
     * Search flights by source airport code.
     */
    public List<Flight> searchBySource(String sourceCode) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getSourceAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(sourceCode))
                .collect(Collectors.toList());
    }

    /**
     * Search flights by destination airport code.
     */
    public List<Flight> searchByDestination(String destinationCode) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getDestinationAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(destinationCode))
                .collect(Collectors.toList());
    }

    /**
     * Search flights by source and destination.
     */
    public List<Flight> searchByRoute(String sourceCode,
                                      String destinationCode) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getSourceAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(sourceCode))
                .filter(flight ->
                        flight.getDestinationAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(destinationCode))
                .collect(Collectors.toList());
    }

    /**
     * Search flights by departure date.
     */
    public List<Flight> searchByDepartureDate(LocalDate departureDate) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getDepartureTime()
                                .toLocalDate()
                                .equals(departureDate))
                .collect(Collectors.toList());
    }

    /**
     * Search flights by travel class.
     */
    public List<Flight> searchByTravelClass(TravelClass travelClass) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getTravelClass() == travelClass)
                .collect(Collectors.toList());
    }

    /**
     * Search flights by airline.
     */
    public List<Flight> searchByAirline(String airlineName) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getAirline()
                                .getAirlineName()
                                .equalsIgnoreCase(airlineName))
                .collect(Collectors.toList());
    }
    /**
     * Filter flights by price range.
     */
    public List<Flight> filterByPriceRange(double minimumPrice,
                                           double maximumPrice) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getTotalFare() >= minimumPrice &&
                                flight.getTotalFare() <= maximumPrice)
                .collect(Collectors.toList());
    }

    /**
     * Filter flights by maximum number of stops.
     */
    public List<Flight> filterByStops(int maximumStops) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getStops() <= maximumStops)
                .collect(Collectors.toList());
    }

    /**
     * Filter flights by maximum duration (in minutes).
     */
    public List<Flight> filterByDuration(int maximumDuration) {

        return repository.getAllFlights()
                .stream()
                .filter(flight ->
                        flight.getFlightDuration().toMinutes()
                                <= maximumDuration)
                .collect(Collectors.toList());
    }

    /**
     * Filter flights by departure time.
     */
    public List<Flight> filterByDepartureTime(int startHour,
                                              int endHour) {

        return repository.getAllFlights()
                .stream()
                .filter(flight -> {

                    int hour =
                            flight.getDepartureTime().getHour();

                    return hour >= startHour &&
                            hour <= endHour;
                })
                .collect(Collectors.toList());
    }

    /**
     * Filter flights by arrival time.
     */
    public List<Flight> filterByArrivalTime(int startHour,
                                            int endHour) {

        return repository.getAllFlights()
                .stream()
                .filter(flight -> {

                    int hour =
                            flight.getArrivalTime().getHour();

                    return hour >= startHour &&
                            hour <= endHour;
                })
                .collect(Collectors.toList());
    }

    /**
     * Search using FlightSearchCriteria.
     */
    public List<Flight> search(
            model.FlightSearchCriteria criteria) {

        return repository.getAllFlights()
                .stream()

                // Source
                .filter(flight ->
                        criteria.getSource() == null ||
                                flight.getSourceAirport()
                                        .getAirportCode()
                                        .equalsIgnoreCase(criteria.getSource()))

                // Destination
                .filter(flight ->
                        criteria.getDestination() == null ||
                                flight.getDestinationAirport()
                                        .getAirportCode()
                                        .equalsIgnoreCase(criteria.getDestination()))

                // Departure Date
                .filter(flight ->
                        criteria.getDepartureDate() == null ||
                                flight.getDepartureTime()
                                        .toLocalDate()
                                        .equals(criteria.getDepartureDate()))

                // Travel Class
                .filter(flight ->
                        criteria.getTravelClass() == null ||
                                flight.getTravelClass()
                                        == criteria.getTravelClass())

                // Airline
                .filter(flight ->
                        !criteria.hasPreferredAirline() ||
                                flight.getAirline()
                                        .getAirlineName()
                                        .equalsIgnoreCase(
                                                criteria.getPreferredAirline()))

                // Price
                .filter(flight ->
                        flight.getTotalFare()
                                >= criteria.getMinimumPrice())

                .filter(flight ->
                        criteria.getMaximumPrice() == 0 ||
                                flight.getTotalFare()
                                        <= criteria.getMaximumPrice())

                // Stops
                .filter(flight ->
                        flight.getStops()
                                <= criteria.getMaximumStops())

                // Duration
                .filter(flight ->
                        flight.getFlightDuration()
                                .toMinutes()
                                <= criteria.getMaximumDuration())

                // Seat Availability
                .filter(flight ->
                        hasAvailableSeats(
                                flight,
                                criteria.getTotalPassengers()))

                .collect(Collectors.toList());
    }

    /**
     * Checks whether enough seats are available.
     */
    public boolean hasAvailableSeats(
            Flight flight,
            int passengers) {

        return flight.getAvailableSeats() >= passengers;
    }

}