package service;

import enums.FlightStatus;
import model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightManagementService {

    private List<Flight> flights;

    public FlightManagementService() {

        flights = new ArrayList<>();

    }

    // ------------------------------------------
    // Create Flight
    // ------------------------------------------

    public void createFlight(Flight flight) {

        if (flight == null) {

            System.out.println("Invalid Flight.");

            return;
        }

        flights.add(flight);

        System.out.println("Flight Created Successfully.");

    }

    // ------------------------------------------
    // Update Flight Schedule
    // ------------------------------------------

    public void updateSchedule(Flight flight,
                               LocalDateTime departure,
                               LocalDateTime arrival) {

        if (flight == null) {

            System.out.println("Flight Not Found.");

            return;
        }

        flight.setDepartureTime(departure);
        flight.setArrivalTime(arrival);

        System.out.println("Flight Schedule Updated.");

    }

    // ------------------------------------------
    // Update Fare
    // ------------------------------------------

    public void updateFare(Flight flight,
                           double fare) {

        if (flight == null) {

            System.out.println("Flight Not Found.");

            return;
        }

        flight.setBaseFare(fare);

        System.out.println("Fare Updated.");

    }

    // ------------------------------------------
    // Update Available Seats
    // ------------------------------------------

    public void updateSeats(Flight flight,
                            int seats) {

        if (flight == null) {

            System.out.println("Flight Not Found.");

            return;
        }

        flight.setAvailableSeats(seats);

        System.out.println("Seat Availability Updated.");

    }

    // ------------------------------------------
    // Change Aircraft
    // ------------------------------------------

    public void changeAircraft(Flight flight,
                               String aircraft) {

        if (flight == null) {

            System.out.println("Flight Not Found.");

            return;
        }

        flight.setAircraft(aircraft);

        System.out.println("Aircraft Updated.");

    }

    // ------------------------------------------
    // Update Flight Status
    // ------------------------------------------

    public void updateStatus(Flight flight,
                             FlightStatus status) {

        if (flight == null) {

            System.out.println("Flight Not Found.");

            return;
        }

        flight.setStatus(status);

        System.out.println("Flight Status Updated.");

    }

    // ------------------------------------------
    // Search by Flight Number
    // ------------------------------------------

    public Flight searchFlight(String flightNumber) {

        for (Flight flight : flights) {

            if (flight.getFlightNumber()
                    .equalsIgnoreCase(flightNumber)) {

                return flight;
            }

        }

        return null;

    }

    // ------------------------------------------
    // Search by Airline
    // ------------------------------------------

    public List<Flight> searchByAirline(String airlineName) {

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getAirline() != null &&
                    flight.getAirline()
                            .getAirlineName()
                            .equalsIgnoreCase(airlineName)) {

                result.add(flight);

            }

        }

        return result;

    }

    // ------------------------------------------
    // Search by Route
    // ------------------------------------------

    public List<Flight> searchByRoute(String source,
                                      String destination) {

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getSourceAirport() != null &&
                    flight.getDestinationAirport() != null &&
                    flight.getSourceAirport()
                            .getAirportCode()
                            .equalsIgnoreCase(source) &&
                    flight.getDestinationAirport()
                            .getAirportCode()
                            .equalsIgnoreCase(destination)) {

                result.add(flight);

            }

        }

        return result;

    }

    // ------------------------------------------
    // Filter by Status
    // ------------------------------------------

    public List<Flight> filterByStatus(
            FlightStatus status) {

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getStatus() == status) {

                result.add(flight);

            }

        }

        return result;

    }

    // ------------------------------------------
    // Display Flights
    // ------------------------------------------

    public void displayFlights(List<Flight> list) {

        if (list.isEmpty()) {

            System.out.println("No Flights Found.");

            return;

        }

        for (Flight flight : list) {

            System.out.println(flight);

        }

    }

    // ------------------------------------------
    // Generate Flight Report
    // ------------------------------------------

    public void generateFlightReport() {

        System.out.println();

        System.out.println("========== FLIGHT REPORT ==========");

        System.out.println("Total Flights : "
                + flights.size());

        for (Flight flight : flights) {

            System.out.println("--------------------------------");

            System.out.println("Flight Number : "
                    + flight.getFlightNumber());

            if (flight.getAirline() != null) {

                System.out.println("Airline : "
                        + flight.getAirline().getAirlineName());

            }

            System.out.println("Status : "
                    + flight.getStatus());

            System.out.println("Available Seats : "
                    + flight.getAvailableSeats());

            System.out.println("Fare : ₹"
                    + flight.getFare());

        }

        System.out.println("--------------------------------");

    }

    // ------------------------------------------
    // Get All Flights
    // ------------------------------------------

    public List<Flight> getFlights() {

        return flights;

    }
    // -----------------------------------
// Add Flight
// -----------------------------------

    public void addFlight(Flight flight) {

        if (flight == null) {

            System.out.println("Invalid Flight.");

            return;

        }

        flights.add(flight);

    }

    // -----------------------------------
// Get All Flights
// -----------------------------------

    public List<Flight> getAllFlights() {

        return flights;

    }


}