package service;

import model.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportManagementService {

    private List<Airport> airports;

    public AirportManagementService() {

        airports = new ArrayList<>();

    }

    // -----------------------------------------
    // Add Airport
    // -----------------------------------------

    public void addAirport(Airport airport) {

        if (airport == null) {

            System.out.println("Invalid Airport.");

            return;

        }

        airports.add(airport);

        System.out.println("Airport Added Successfully.");

    }

    // -----------------------------------------
    // Update Airport Details
    // -----------------------------------------

    public void updateAirport(Airport airport,
                              String airportName,
                              String city,
                              String country,
                              String timezone,
                              String terminal,
                              boolean active,
                              String contactNumber) {

        if (airport == null) {

            System.out.println("Airport Not Found.");

            return;

        }

        airport.setAirportName(airportName);
        airport.setCity(city);
        airport.setCountry(country);
        airport.setTimezone(timezone);
        airport.setTerminal(terminal);
        airport.setActive(active);
        airport.setContactNumber(contactNumber);

        System.out.println("Airport Updated Successfully.");

    }

    // -----------------------------------------
    // Search by Airport Code
    // -----------------------------------------

    public Airport searchByCode(String airportCode) {

        for (Airport airport : airports) {

            if (airport.getAirportCode()
                    .equalsIgnoreCase(airportCode)) {

                return airport;

            }

        }

        return null;

    }

    // -----------------------------------------
    // Search by Airport Name
    // -----------------------------------------

    public List<Airport> searchByName(String airportName) {

        List<Airport> result = new ArrayList<>();

        for (Airport airport : airports) {

            if (airport.getAirportName()
                    .toLowerCase()
                    .contains(airportName.toLowerCase())) {

                result.add(airport);

            }

        }

        return result;

    }

    // -----------------------------------------
    // Search by City
    // -----------------------------------------

    public List<Airport> searchByCity(String city) {

        List<Airport> result = new ArrayList<>();

        for (Airport airport : airports) {

            if (airport.getCity()
                    .equalsIgnoreCase(city)) {

                result.add(airport);

            }

        }

        return result;

    }

    // -----------------------------------------
    // List Airports by Country
    // -----------------------------------------

    public List<Airport> listByCountry(String country) {

        List<Airport> result = new ArrayList<>();

        for (Airport airport : airports) {

            if (airport.getCountry()
                    .equalsIgnoreCase(country)) {

                result.add(airport);

            }

        }

        return result;

    }

    // -----------------------------------------
    // Airport Suggestion
    // -----------------------------------------

    public List<Airport> suggestAirport(String keyword) {

        List<Airport> result = new ArrayList<>();

        for (Airport airport : airports) {

            if (airport.getAirportCode()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())

                    ||

                    airport.getAirportName()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                    ||

                    airport.getCity()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())) {

                result.add(airport);

            }

        }

        return result;

    }

    // -----------------------------------------
    // Display Airport
    // -----------------------------------------

    public void displayAirport(Airport airport) {

        if (airport == null) {

            System.out.println("Airport Not Found.");

            return;

        }

        System.out.println(airport);

    }

    // -----------------------------------------
    // Display Airport List
    // -----------------------------------------

    public void displayAirports(List<Airport> airportList) {

        if (airportList.isEmpty()) {

            System.out.println("No Airports Found.");

            return;

        }

        for (Airport airport : airportList) {

            System.out.println("--------------------------------");

            System.out.println("Code      : "
                    + airport.getAirportCode());

            System.out.println("Name      : "
                    + airport.getAirportName());

            System.out.println("City      : "
                    + airport.getCity());

            System.out.println("Country   : "
                    + airport.getCountry());

        }

    }

    // -----------------------------------------
    // Get All Airports
    // -----------------------------------------

    public List<Airport> getAirports() {

        return airports;

    }

}