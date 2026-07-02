package model;

import enums.TravelClass;
import enums.TripType;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightSearchCriteria {

    private String source;
    private String destination;

    private LocalDate departureDate;
    private LocalDate returnDate;
    private TripType tripType;

    private int adults;
    private int children;
    private int infants;

    private TravelClass travelClass;
    private String preferredAirline;

    private double minimumPrice;
    private double maximumPrice;
    private int maximumStops;
    private int maximumDuration;

    private LocalTime departureStartTime;
    private LocalTime departureEndTime;
    private LocalTime arrivalStartTime;
    private LocalTime arrivalEndTime;

    public FlightSearchCriteria() {
    }

    public FlightSearchCriteria(String source,
                                String destination,
                                LocalDate departureDate,
                                LocalDate returnDate,
                                TripType tripType,
                                int adults,
                                int children,
                                int infants,
                                TravelClass travelClass,
                                String preferredAirline,
                                double minimumPrice,
                                double maximumPrice,
                                int maximumStops,
                                int maximumDuration,
                                LocalTime departureStartTime,
                                LocalTime departureEndTime,
                                LocalTime arrivalStartTime,
                                LocalTime arrivalEndTime) {

        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.tripType = tripType;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
        this.travelClass = travelClass;
        this.preferredAirline = preferredAirline;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
        this.maximumStops = maximumStops;
        this.maximumDuration = maximumDuration;
        this.departureStartTime = departureStartTime;
        this.departureEndTime = departureEndTime;
        this.arrivalStartTime = arrivalStartTime;
        this.arrivalEndTime = arrivalEndTime;
    }

    public int getTotalPassengers() {
        return adults + children + infants;
    }

    public boolean isOneWay() {
        return tripType == TripType.ONE_WAY;
    }

    public boolean isRoundTrip() {
        return tripType == TripType.ROUND_TRIP;
    }

    public boolean isMultiCity() {
        return tripType == TripType.MULTI_CITY;
    }

    public boolean hasPreferredAirline() {
        return preferredAirline != null && !preferredAirline.trim().isEmpty();
    }

    // Getters

    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDate getDepartureDate() { return departureDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public TripType getTripType() { return tripType; }
    public int getAdults() { return adults; }
    public int getChildren() { return children; }
    public int getInfants() { return infants; }
    public TravelClass getTravelClass() { return travelClass; }
    public String getPreferredAirline() { return preferredAirline; }
    public double getMinimumPrice() { return minimumPrice; }
    public double getMaximumPrice() { return maximumPrice; }
    public int getMaximumStops() { return maximumStops; }
    public int getMaximumDuration() { return maximumDuration; }
    public LocalTime getDepartureStartTime() { return departureStartTime; }
    public LocalTime getDepartureEndTime() { return departureEndTime; }
    public LocalTime getArrivalStartTime() { return arrivalStartTime; }
    public LocalTime getArrivalEndTime() { return arrivalEndTime; }
}