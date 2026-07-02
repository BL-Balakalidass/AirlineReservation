package model;

import enums.FlightStatus;
import enums.TravelClass;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {

    // Flight Information
    private String flightNumber;
    private Airline airline;
    private String aircraft;

    // Route Information
    private Airport sourceAirport;
    private Airport destinationAirport;

    // Schedule
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    // Travel
    private TravelClass travelClass;

    // Fare Details
    private double baseFare;
    private double tax;
    private double serviceCharge;

    // Seats
    private int availableSeats;

    // Flight Details
    private int stops;
    private int layoverMinutes;

    // Baggage
    private int cabinBaggage;
    private int checkInBaggage;

    // Amenities
    private boolean wifi;
    private boolean meals;
    private boolean entertainment;

    // Policies
    private String cancellationPolicy;
    private String modificationPolicy;

    // Status
    private FlightStatus status;

    public Flight() {

    }

    public Flight(String flightNumber,
                  Airline airline,
                  String aircraft,
                  Airport sourceAirport,
                  Airport destinationAirport,
                  LocalDateTime departureTime,
                  LocalDateTime arrivalTime,
                  TravelClass travelClass,
                  double baseFare,
                  double tax,
                  double serviceCharge,
                  int availableSeats,
                  int stops,
                  int layoverMinutes,
                  int cabinBaggage,
                  int checkInBaggage,
                  boolean wifi,
                  boolean meals,
                  boolean entertainment,
                  String cancellationPolicy,
                  String modificationPolicy,
                  FlightStatus status) {

        this.flightNumber = flightNumber;
        this.airline = airline;
        this.aircraft = aircraft;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelClass = travelClass;
        this.baseFare = baseFare;
        this.tax = tax;
        this.serviceCharge = serviceCharge;
        this.availableSeats = availableSeats;
        this.stops = stops;
        this.layoverMinutes = layoverMinutes;
        this.cabinBaggage = cabinBaggage;
        this.checkInBaggage = checkInBaggage;
        this.wifi = wifi;
        this.meals = meals;
        this.entertainment = entertainment;
        this.cancellationPolicy = cancellationPolicy;
        this.modificationPolicy = modificationPolicy;
        this.status = status;
    }

    public Flight(String ai101, String chennai, String delhi, int i) {
    }

    // ---------------------------
    // Getters and Setters
    // ---------------------------

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public int getLayoverMinutes() {
        return layoverMinutes;
    }

    public void setLayoverMinutes(int layoverMinutes) {
        this.layoverMinutes = layoverMinutes;
    }

    public int getCabinBaggage() {
        return cabinBaggage;
    }

    public void setCabinBaggage(int cabinBaggage) {
        this.cabinBaggage = cabinBaggage;
    }

    public int getCheckInBaggage() {
        return checkInBaggage;
    }

    public void setCheckInBaggage(int checkInBaggage) {
        this.checkInBaggage = checkInBaggage;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isMeals() {
        return meals;
    }

    public void setMeals(boolean meals) {
        this.meals = meals;
    }

    public boolean isEntertainment() {
        return entertainment;
    }

    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public String getModificationPolicy() {
        return modificationPolicy;
    }

    public void setModificationPolicy(String modificationPolicy) {
        this.modificationPolicy = modificationPolicy;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    // -------------------------------------------------
    // Helper Methods
    // -------------------------------------------------

    public double getTotalFare() {
        return baseFare + tax + serviceCharge;
    }

    public Duration getFlightDuration() {
        return Duration.between(departureTime, arrivalTime);
    }

    public String getFormattedDuration() {

        Duration duration = getFlightDuration();

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return hours + " hr " + minutes + " min";
    }

    public String getRoute() {

        return sourceAirport.getAirportCode()
                + " -> "
                + destinationAirport.getAirportCode();
    }

    public boolean hasAvailableSeats(int passengers) {

        return availableSeats >= passengers;
    }

    public boolean isNonStopFlight() {

        return stops == 0;
    }

    public boolean isConnectingFlight() {

        return stops > 0;
    }

    public void reserveSeats(int passengers) {

        if (!hasAvailableSeats(passengers)) {

            throw new IllegalArgumentException(
                    "Not enough seats available."
            );
        }

        availableSeats -= passengers;
    }

    public void cancelSeats(int passengers) {

        availableSeats += passengers;
    }

    @Override
    public String toString() {

        return "\n===============================" +
                "\nFlight Number      : " + flightNumber +
                "\nAirline            : " + airline.getAirlineName() +
                "\nAircraft           : " + aircraft +
                "\nRoute              : " + getRoute() +
                "\nDeparture          : " + departureTime +
                "\nArrival            : " + arrivalTime +
                "\nDuration           : " + getFormattedDuration() +
                "\nTravel Class       : " + travelClass +
                "\nBase Fare          : ₹" + baseFare +
                "\nTax                : ₹" + tax +
                "\nService Charge     : ₹" + serviceCharge +
                "\nTotal Fare         : ₹" + getTotalFare() +
                "\nAvailable Seats    : " + availableSeats +
                "\nStops              : " + stops +
                "\nLayover            : " + layoverMinutes + " min" +
                "\nCabin Baggage      : " + cabinBaggage + " kg" +
                "\nCheck-in Baggage   : " + checkInBaggage + " kg" +
                "\nWiFi               : " + (wifi ? "Yes" : "No") +
                "\nMeals              : " + (meals ? "Available" : "No") +
                "\nEntertainment      : " + (entertainment ? "Available" : "No") +
                "\nStatus             : " + status +
                "\nCancellation       : " + cancellationPolicy +
                "\nModification       : " + modificationPolicy +
                "\n===============================";
    }

    public double getFare() {
        return baseFare;
    }
}