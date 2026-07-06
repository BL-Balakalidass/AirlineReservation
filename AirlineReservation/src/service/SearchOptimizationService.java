package service;

import model.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchOptimizationService {

    // =====================================================
    // ROUTE CACHE
    // =====================================================

    private Map<String, List<Flight>> routeCache =
            new HashMap<>();

    // =====================================================
    // POPULAR FLIGHT CACHE
    // =====================================================

    private Map<String, Integer> popularFlights =
            new LinkedHashMap<>();

    // =====================================================
    // CACHE SEARCHED ROUTE
    // =====================================================

    public void cacheRoute(String route,
                           List<Flight> flights) {

        routeCache.put(route, flights);

        System.out.println(
                "Route cached successfully : "
                        + route);

    }

    // =====================================================
    // GET CACHED ROUTE
    // =====================================================

    public List<Flight> getCachedRoute(String route) {

        if (routeCache.containsKey(route)) {

            System.out.println(
                    "Loading results from cache...");

            return routeCache.get(route);

        }

        System.out.println(
                "No cache available.");

        return new ArrayList<>();

    }

    // =====================================================
    // SEARCH FLIGHTS
    // =====================================================

    public List<Flight> searchFlights(
            List<Flight> flights,
            String source,
            String destination) {

        List<Flight> results =
                new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getSourceAirport()
                    .getAirportCode()
                    .equalsIgnoreCase(source)

                    &&

                    flight.getDestinationAirport()
                            .getAirportCode()
                            .equalsIgnoreCase(destination)) {

                results.add(flight);

            }

        }

        System.out.println("\nSearch Results : "
                + results.size());

        return results;

    }

    // =====================================================
    // PAGINATION
    // =====================================================

    public List<Flight> paginateFlights(
            List<Flight> flights,
            int page,
            int pageSize) {

        List<Flight> pageData =
                new ArrayList<>();

        int start =
                (page - 1) * pageSize;

        int end =
                Math.min(start + pageSize,
                        flights.size());

        if (start >= flights.size()) {

            return pageData;

        }

        for (int i = start; i < end; i++) {

            pageData.add(flights.get(i));

        }

        System.out.println(
                "Displaying Page "
                        + page);

        return pageData;

    }

    // =====================================================
    // CACHE POPULAR FLIGHTS
    // =====================================================

    public void cachePopularFlights(
            List<Flight> flights) {

        for (Flight flight : flights) {

            String flightNo =
                    flight.getFlightNumber();

            popularFlights.put(
                    flightNo,
                    popularFlights.getOrDefault(
                            flightNo,
                            0) + 1);

        }

        System.out.println(
                "Popular flights cache updated.");

    }

    // =====================================================
    // DISPLAY CACHED ROUTES
    // =====================================================

    public void displayCachedRoutes() {

        System.out.println("\n==================================");
        System.out.println("CACHED ROUTES");
        System.out.println("==================================");

        if (routeCache.isEmpty()) {

            System.out.println(
                    "No cached routes.");

            return;

        }

        for (String route : routeCache.keySet()) {

            System.out.println(
                    route
                            + " -> "
                            + routeCache.get(route).size()
                            + " flights");

        }

    }

    // =====================================================
    // DISPLAY POPULAR FLIGHTS
    // =====================================================

    public void displayPopularFlights() {

        System.out.println("\n==================================");
        System.out.println("POPULAR FLIGHTS");
        System.out.println("==================================");

        if (popularFlights.isEmpty()) {

            System.out.println(
                    "No popular flights.");

            return;

        }

        for (String flight : popularFlights.keySet()) {

            System.out.println(
                    flight
                            + " : "
                            + popularFlights.get(flight)
                            + " searches");

        }

    }
    // =====================================================
    // AUTO COMPLETE AIRPORT
    // =====================================================

    public List<String> autoCompleteAirport(
            List<String> airports,
            String keyword) {

        List<String> suggestions =
                new ArrayList<>();

        if (keyword == null) {

            return suggestions;

        }

        for (String airport : airports) {

            if (airport.toLowerCase()
                    .startsWith(
                            keyword.toLowerCase())) {

                suggestions.add(airport);

            }

        }

        System.out.println(
                "\nAuto-complete Suggestions");

        for (String airport : suggestions) {

            System.out.println(airport);

        }

        return suggestions;

    }

    // =====================================================
    // NEARBY AIRPORT SUGGESTIONS
    // =====================================================

    public List<String> suggestNearbyAirports(
            String airportCode) {

        List<String> nearby =
                new ArrayList<>();

        switch (airportCode.toUpperCase()) {

            case "MAA":

                nearby.add("TIR - Tirupati");
                nearby.add("BLR - Bengaluru");
                nearby.add("TRZ - Tiruchirappalli");

                break;

            case "DEL":

                nearby.add("JAI - Jaipur");
                nearby.add("IXC - Chandigarh");
                nearby.add("LKO - Lucknow");

                break;

            case "BOM":

                nearby.add("PNQ - Pune");
                nearby.add("GOI - Goa");
                nearby.add("NAG - Nagpur");

                break;

            default:

                nearby.add("No nearby airports found.");

        }

        System.out.println(
                "\nNearby Airports");

        for (String airport : nearby) {

            System.out.println(airport);

        }

        return nearby;

    }

    // =====================================================
    // RECOMMEND TRAVEL DATES
    // =====================================================

    public void recommendTravelDates(
            LocalDate travelDate) {

        System.out.println(
                "\nRecommended Travel Dates");

        System.out.println(
                travelDate.minusDays(2));

        System.out.println(
                travelDate.minusDays(1));

        System.out.println(
                travelDate);

        System.out.println(
                travelDate.plusDays(1));

        System.out.println(
                travelDate.plusDays(2));

    }

    // =====================================================
    // PRICE TREND
    // =====================================================

    public void showPriceTrend(
            Flight flight) {

        System.out.println(
                "\nPrice Trend");

        double fare =
                flight.getFare();

        System.out.println(
                "5 Days Ago : ₹"
                        + (fare - 1500));

        System.out.println(
                "3 Days Ago : ₹"
                        + (fare - 900));

        System.out.println(
                "Yesterday  : ₹"
                        + (fare - 300));

        System.out.println(
                "Today      : ₹"
                        + fare);

        System.out.println(
                "Tomorrow*  : ₹"
                        + (fare + 600));

    }

    // =====================================================
    // FLEXIBLE DATE SEARCH
    // =====================================================

    public void flexibleDateSearch(
            LocalDate selectedDate) {

        System.out.println(
                "\nFlexible Date Search");

        for (int i = -3; i <= 3; i++) {

            System.out.println(
                    selectedDate.plusDays(i));

        }

    }

    // =====================================================
    // DISPLAY SEARCH RESULTS
    // =====================================================

    public void displayFlights(
            List<Flight> flights) {

        System.out.println(
                "\n==================================");
        System.out.println(
                "SEARCH RESULTS");
        System.out.println(
                "==================================");

        if (flights == null ||
                flights.isEmpty()) {

            System.out.println(
                    "No flights found.");

            return;

        }

        for (Flight flight : flights) {

            System.out.println(flight);

        }

    }

    // =====================================================
    // CLEAR CACHE
    // =====================================================

    public void clearCache() {

        routeCache.clear();

        popularFlights.clear();

        System.out.println(
                "Search cache cleared.");

    }

}