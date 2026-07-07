package service;

import model.Airport;

import java.time.LocalDateTime;
import java.util.List;

public class AirportDataService {

    // =====================================================
    // AIRPORT DATA PROVIDER
    // =====================================================

    private static final String PROVIDER =
            "Airport Information Service";

    // =====================================================
    // FETCH AIRPORT DETAILS
    // =====================================================

    public Airport fetchAirport(
            List<Airport> airports,
            String airportCode) {

        System.out.println(
                "\n====================================");

        System.out.println(
                "AIRPORT DATA SERVICE");

        System.out.println(
                "====================================");

        System.out.println(
                "Provider : "
                        + PROVIDER);

        if (airports == null ||
                airportCode == null) {

            return null;

        }

        for (Airport airport : airports) {

            if (airport.getAirportCode()
                    .equalsIgnoreCase(airportCode)) {

                System.out.println(
                        "Airport Found.");

                return airport;

            }

        }

        System.out.println(
                "Airport Not Found.");

        return null;

    }

    // =====================================================
    // FETCH WEATHER
    // =====================================================

    public void fetchWeather(
            Airport airport) {

        if (airport == null) {

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "WEATHER INFORMATION");

        System.out.println(
                "====================================");

        System.out.println(
                "Airport : "
                        + airport.getAirportName());

        System.out.println(
                "City : "
                        + airport.getCity());

        System.out.println(
                "Weather : Clear Sky");

        System.out.println(
                "Temperature : 30°C");

        System.out.println(
                "Humidity : 68%");

        System.out.println(
                "Wind Speed : 12 km/h");

    }

    // =====================================================
    // FETCH GATE INFORMATION
    // =====================================================

    public void fetchGateInformation(
            String flightNumber) {

        System.out.println(
                "\n====================================");

        System.out.println(
                "GATE INFORMATION");

        System.out.println(
                "====================================");

        System.out.println(
                "Flight : "
                        + flightNumber);

        System.out.println(
                "Terminal : T1");

        System.out.println(
                "Gate : A12");

        System.out.println(
                "Boarding Time : "
                        + LocalDateTime.now()
                        .plusMinutes(45));

    }

    // =====================================================
    // FETCH DELAY STATUS
    // =====================================================

    public void fetchDelayStatus(
            String flightNumber) {

        System.out.println(
                "\n====================================");

        System.out.println(
                "FLIGHT DELAY STATUS");

        System.out.println(
                "====================================");

        System.out.println(
                "Flight : "
                        + flightNumber);

        System.out.println(
                "Status : ON TIME");

        System.out.println(
                "Delay : 0 Minutes");

    }

    // =====================================================
    // FETCH TERMINAL INFORMATION
    // =====================================================

    public void fetchTerminalInformation(
            Airport airport) {

        if (airport == null) {

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "TERMINAL INFORMATION");

        System.out.println(
                "====================================");

        System.out.println(
                "Airport : "
                        + airport.getAirportName());

        System.out.println(
                "Terminal 1 : Domestic");

        System.out.println(
                "Terminal 2 : International");

    }

    // =====================================================
    // FETCH FACILITIES
    // =====================================================

    public void fetchFacilities(
            Airport airport) {

        if (airport == null) {

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "AIRPORT FACILITIES");

        System.out.println(
                "====================================");

        System.out.println(
                "Airport : "
                        + airport.getAirportName());

        System.out.println(
                "✓ Free WiFi");

        System.out.println(
                "✓ Lounge");

        System.out.println(
                "✓ ATM");

        System.out.println(
                "✓ Restaurants");

        System.out.println(
                "✓ Medical Centre");

        System.out.println(
                "✓ Duty Free Shops");

    }

    // =====================================================
    // DISPLAY AIRPORT DETAILS
    // =====================================================

    public void displayAirport(
            Airport airport) {

        if (airport == null) {

            System.out.println(
                    "Airport Not Available.");

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "AIRPORT DETAILS");

        System.out.println(
                "====================================");

        System.out.println(
                "Code : "
                        + airport.getAirportCode());

        System.out.println(
                "Name : "
                        + airport.getAirportName());

        System.out.println(
                "City : "
                        + airport.getCity());

        System.out.println(
                "Country : "
                        + airport.getCountry());

        System.out.println(
                "Timezone : "
                        + airport.getTimeZone());

        System.out.println(
                "Status : "
                        + (airport.isActive()
                        ? "ACTIVE"
                        : "INACTIVE"));

    }

    // =====================================================
    // DISPLAY PROVIDER
    // =====================================================

    public void displayProvider() {

        System.out.println(
                "\nAirport Data Provider : "
                        + PROVIDER);

    }

}