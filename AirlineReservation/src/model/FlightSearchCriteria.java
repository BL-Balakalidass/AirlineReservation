package model;

import enums.TravelClass;
import enums.TripType;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightSearchCriteria {

    // Route
    private String source;
    private String destination;

    // Journey Details
    private LocalDate departureDate;
    private LocalDate returnDate;
    private TripType tripType;

    // Passengers
    private int adults;
    private int children;
    private int infants;

    // Preferences
    private TravelClass travelClass;
    private String preferredAirline;

    // Filters
    private double minimumPrice;
    private double maximumPrice;
    private int maximumStops;
    private int maximumDuration; // Minutes

    // Departure Time Filter
    private LocalTime package model;

    public class FlightSearchCriteria {

        // Route
        private String source;
        private String destination;

        // Journey Details
        private LocalDate departureDate;
        private LocalDate returnDate;
        private TripType tripType;

        // Passengers
        private int adults;
        private int children;
        private int infants;

        // Preferences
        private TravelClass travelClass;
        private String preferredAirline;

        // Filters
        private double minimumPrice;
        private double maximumPrice;
        private int maximumStops;
        private int maximumDuration; // Minutes

        // Departure Time Filter
        private LocalTime departureStartTime;
        private LocalTime departureEndTime;

        // Arrival Time Filter
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

        // -------------------------
        // Getters and Setters
        // -------------------------

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public LocalDate getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(LocalDate departureDate) {
            this.departureDate = departureDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }

        public TripType getTripType() {
            return tripType;
        }

        public void setTripType(TripType tripType) {
            this.tripType = tripType;
        }

        public int getAdults() {
            return adults;
        }

        public void setAdults(int adults) {
            this.adults = adults;
        }

        public int getChildren() {
            return children;
        }

        public void setChildren(int children) {
            this.children = children;
        }

        public int getInfants() {
            return infants;
        }

        public void setInfants(int infants) {
            this.infants = infants;
        }

        public TravelClass getTravelClass() {
            return travelClass;
        }

        public void setTravelClass(TravelClass travelClass) {
            this.travelClass = travelClass;
        }

        public String getPreferredAirline() {
            return preferredAirline;
        }

        public void setPreferredAirline(String preferredAirline) {
            this.preferredAirline = preferredAirline;
        }

        public double getMinimumPrice() {
            return minimumPrice;
        }

        public void setMinimumPrice(double minimumPrice) {
            this.minimumPrice = minimumPrice;
        }

        public double getMaximumPrice() {
            return maximumPrice;
        }

        public void setMaximumPrice(double maximumPrice) {
            this.maximumPrice = maximumPrice;
        }

        public int getMaximumStops() {
            return maximumStops;
        }

        public void setMaximumStops(int maximumStops) {
            this.maximumStops = maximumStops;
        }

        public int getMaximumDuration() {
            return maximumDuration;
        }

        public void setMaximumDuration(int maximumDuration) {
            this.maximumDuration = maximumDuration;
        }

        public LocalTime getDepartureStartTime() {
            return departureStartTime;
        }

        public void setDepartureStartTime(LocalTime departureStartTime) {
            this.departureStartTime = departureStartTime;
        }

        public LocalTime getDepartureEndTime() {
            return departureEndTime;
        }

        public void setDepartureEndTime(LocalTime departureEndTime) {
            this.departureEndTime = departureEndTime;
        }

        public LocalTime getArrivalStartTime() {
            return arrivalStartTime;
        }

        public void setArrivalStartTime(LocalTime arrivalStartTime) {
            this.arrivalStartTime = arrivalStartTime;
        }

        public LocalTime getArrivalEndTime() {
            return arrivalEndTime;
        }

        public void setArrivalEndTime(LocalTime arrivalEndTime) {
            this.arrivalEndTime = arrivalEndTime;
        }

        // -------------------------
        // Helper Methods
        // -------------------------

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
            return preferredAirline != null &&
                    !preferredAirline.trim().isEmpty();
        }

        @Override
        public String toString() {

            return "\n========== Flight Search ==========" +
                    "\nSource              : " + source +
                    "\nDestination         : " + destination +
                    "\nDeparture Date      : " + departureDate +
                    "\nReturn Date         : " + returnDate +
                    "\nTrip Type           : " + tripType +
                    "\nAdults              : " + adults +
                    "\nChildren            : " + children +
                    "\nInfants             : " + infants +
                    "\nTotal Passengers    : " + getTotalPassengers() +
                    "\nTravel Class        : " + travelClass +
                    "\nPreferred Airline   : " + preferredAirline +
                    "\nPrice Range         : ₹" +
                    minimumPrice + " - ₹" + maximumPrice +
                    "\nMaximum Stops       : " + maximumStops +
                    "\nMaximum Duration    : " +
                    maximumDuration + " minutes" +
                    "\nDeparture Time      : " +
                    departureStartTime + " - " + departureEndTime +
                    "\nArrival Time        : " +
                    arrivalStartTime + " - " + arrivalEndTime +
                    "\n===================================";
        }
    }departureStartTime;
    private LocalTime departureEndTime;

    // Arrival Time Filter
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

    // -------------------------
    // Getters and Setters
    // -------------------------

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getInfants() {
        return infants;
    }

    public void setInfants(int infants) {
        this.infants = infants;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public String getPreferredAirline() {
        return preferredAirline;
    }

    public void setPreferredAirline(String preferredAirline) {
        this.preferredAirline = preferredAirline;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public double getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(double maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public int getMaximumStops() {
        return maximumStops;
    }

    public void setMaximumStops(int maximumStops) {
        this.maximumStops = maximumStops;
    }

    public int getMaximumDuration() {
        return maximumDuration;
    }

    public void setMaximumDuration(int maximumDuration) {
        this.maximumDuration = maximumDuration;
    }

    public LocalTime getDepartureStartTime() {
        return departureStartTime;
    }

    public void setDepartureStartTime(LocalTime departureStartTime) {
        this.departureStartTime = departureStartTime;
    }

    public LocalTime getDepartureEndTime() {
        return departureEndTime;
    }

    public void setDepartureEndTime(LocalTime departureEndTime) {
        this.departureEndTime = departureEndTime;
    }

    public LocalTime getArrivalStartTime() {
        return arrivalStartTime;
    }

    public void setArrivalStartTime(LocalTime arrivalStartTime) {
        this.arrivalStartTime = arrivalStartTime;
    }

    public LocalTime getArrivalEndTime() {
        return arrivalEndTime;
    }

    public void setArrivalEndTime(LocalTime arrivalEndTime) {
        this.arrivalEndTime = arrivalEndTime;
    }

    // -------------------------
    // Helper Methods
    // -------------------------

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
        return preferredAirline != null &&
                !preferredAirline.trim().isEmpty();
    }

    @Override
    public String toString() {

        return "\n========== Flight Search ==========" +
                "\nSource              : " + source +
                "\nDestination         : " + destination +
                "\nDeparture Date      : " + departureDate +
                "\nReturn Date         : " + returnDate +
                "\nTrip Type           : " + tripType +
                "\nAdults              : " + adults +
                "\nChildren            : " + children +
                "\nInfants             : " + infants +
                "\nTotal Passengers    : " + getTotalPassengers() +
                "\nTravel Class        : " + travelClass +
                "\nPreferred Airline   : " + preferredAirline +
                "\nPrice Range         : ₹" +
                minimumPrice + " - ₹" + maximumPrice +
                "\nMaximum Stops       : " + maximumStops +
                "\nMaximum Duration    : " +
                maximumDuration + " minutes" +
                "\nDeparture Time      : " +
                departureStartTime + " - " + departureEndTime +
                "\nArrival Time        : " +
                arrivalStartTime + " - " + arrivalEndTime +
                "\n===================================";
    }
}