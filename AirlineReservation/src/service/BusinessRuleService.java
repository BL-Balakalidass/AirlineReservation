package service;

import model.Booking;
import model.Flight;
import model.Passenger;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BusinessRuleService {

    // =====================================================
    // BOOKING TIME VALIDATION
    // Minimum 2 Hours Before Departure
    // =====================================================

    public boolean validateBookingTime(
            Flight flight) {

        if (flight == null) {

            return false;

        }

        LocalDateTime now =
                LocalDateTime.now();

        LocalDateTime departure =
                flight.getDepartureTime();

        long hours =
                Duration.between(
                        now,
                        departure).toHours();

        if (hours < 2) {

            System.out.println(
                    "Booking not allowed within 2 hours of departure.");

            return false;

        }

        System.out.println(
                "Booking time validation successful.");

        return true;

    }

    // =====================================================
    // MAXIMUM PASSENGERS
    // =====================================================

    public boolean validatePassengerLimit(
            List<Passenger> passengers) {

        if (passengers == null) {

            return false;

        }

        if (passengers.size() > 6) {

            System.out.println(
                    "Maximum 6 passengers allowed per booking.");

            return false;

        }

        System.out.println(
                "Passenger count validation successful.");

        return true;

    }

    // =====================================================
    // INFANT MUST TRAVEL WITH ADULT
    // =====================================================

    public boolean validateInfantWithAdult(
            List<Passenger> passengers) {

        boolean infant = false;
        boolean adult = false;

        for (Passenger passenger : passengers) {

            if (passenger.isInfant()) {

                infant = true;

            }

            if (passenger.isAdult()) {

                adult = true;

            }

        }

        if (infant && !adult) {

            System.out.println(
                    "Infant must travel with an adult.");

            return false;

        }

        System.out.println(
                "Infant rule validation successful.");

        return true;

    }

    // =====================================================
    // AGE CATEGORY VALIDATION
    // =====================================================

    public boolean validatePassengerAge(
            Passenger passenger) {

        if (passenger == null) {

            return false;

        }

        int age =
                passenger.getAge();

        if (age < 2) {

            passenger.setInfant(true);
            passenger.setChild(false);
            passenger.setAdult(false);

            System.out.println(
                    passenger.getFullName()
                            + " : Infant");

        }

        else if (age < 12) {

            passenger.setInfant(false);
            passenger.setChild(true);
            passenger.setAdult(false);

            System.out.println(
                    passenger.getFullName()
                            + " : Child");

        }

        else {

            passenger.setInfant(false);
            passenger.setChild(false);
            passenger.setAdult(true);

            System.out.println(
                    passenger.getFullName()
                            + " : Adult");

        }

        return true;

    }

    // =====================================================
    // TRAVEL DOCUMENT VALIDATION
    // =====================================================

    public boolean validateTravelDocument(
            Passenger passenger) {

        if (passenger == null) {

            return false;

        }

        if (passenger.getPassport() == null ||
                passenger.getPassport().isBlank()) {

            System.out.println(
                    "Passport not available.");

            return false;

        }

        if (passenger.getPassportExpiryDate() == null) {

            System.out.println(
                    "Passport expiry date missing.");

            return false;

        }

        if (passenger.getPassportExpiryDate()
                .isBefore(LocalDate.now())) {

            System.out.println(
                    "Passport expired.");

            return false;

        }

        System.out.println(
                "Travel document validation successful.");

        return true;

    }

    // =====================================================
    // INTERNATIONAL DOCUMENT VALIDATION
    // =====================================================

    public boolean validateInternationalDocuments(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        Flight flight =
                booking.getFlight();

        Passenger passenger =
                booking.getPassenger();

        if (!flight.isInternationalFlight()) {

            System.out.println(
                    "Domestic flight. No international document validation required.");

            return true;

        }

        if (!validateTravelDocument(passenger)) {

            return false;

        }

        System.out.println(
                "International document validation successful.");

        return true;

    }

    // =====================================================
    // COMPLETE BOOKING VALIDATION
    // =====================================================

    public boolean validateBooking(
            Booking booking,
            List<Passenger> passengers) {

        if (booking == null) {

            return false;

        }

        if (!validateBookingTime(
                booking.getFlight())) {

            return false;

        }

        if (!validatePassengerLimit(
                passengers)) {

            return false;

        }

        if (!validateInfantWithAdult(
                passengers)) {

            return false;

        }

        for (Passenger passenger : passengers) {

            if (!validatePassengerAge(
                    passenger)) {

                return false;

            }

            if (!validateTravelDocument(
                    passenger)) {

                return false;

            }

        }

        if (!validateInternationalDocuments(
                booking)) {

            return false;

        }

        System.out.println(
                "\nAll business rules validated successfully.");

        return true;

    }
    // =====================================================
    // DYNAMIC PRICING
    // =====================================================

    public double calculateDynamicFare(
            Flight flight) {

        if (flight == null) {

            return 0;

        }

        double baseFare =
                flight.getFare();

        double multiplier = 1.0;

        if (flight.getDemandMultiplier() > 0) {

            multiplier =
                    flight.getDemandMultiplier();

        }

        double dynamicFare =
                baseFare * multiplier;

        System.out.println(
                "Dynamic Fare : ₹"
                        + dynamicFare);

        return dynamicFare;

    }

    // =====================================================
    // GST CALCULATION
    // =====================================================

    public double calculateGST(
            double fare) {

        double gst =
                fare * 0.05;

        System.out.println(
                "GST (5%) : ₹"
                        + gst);

        return gst;

    }

    // =====================================================
    // AIRPORT CHARGES
    // =====================================================

    public double calculateAirportCharges() {

        double airportCharge = 350.0;

        System.out.println(
                "Airport Charges : ₹"
                        + airportCharge);

        return airportCharge;

    }

    // =====================================================
    // FUEL SURCHARGE
    // =====================================================

    public double calculateFuelSurcharge() {

        double fuelCharge = 500.0;

        System.out.println(
                "Fuel Surcharge : ₹"
                        + fuelCharge);

        return fuelCharge;

    }

    // =====================================================
    // BAGGAGE CHARGES
    // =====================================================

    public double calculateBaggageCharges(
            double excessWeight) {

        if (excessWeight <= 0) {

            System.out.println(
                    "No Excess Baggage.");

            return 0;

        }

        double baggageCharge =
                excessWeight * 250;

        System.out.println(
                "Baggage Charges : ₹"
                        + baggageCharge);

        return baggageCharge;

    }

    // =====================================================
    // SEAT CHARGES
    // =====================================================

    public double calculateSeatCharges(
            boolean premiumSeat) {

        if (!premiumSeat) {

            System.out.println(
                    "Seat Charges : ₹0");

            return 0;

        }

        double seatCharge = 800;

        System.out.println(
                "Seat Charges : ₹"
                        + seatCharge);

        return seatCharge;

    }

    // =====================================================
    // MEAL CHARGES
    // =====================================================

    public double calculateMealCharges(
            boolean upgradedMeal) {

        if (!upgradedMeal) {

            System.out.println(
                    "Meal Charges : ₹0");

            return 0;

        }

        double mealCharge = 400;

        System.out.println(
                "Meal Charges : ₹"
                        + mealCharge);

        return mealCharge;

    }

    // =====================================================
    // APPLY COUPON
    // =====================================================

    public double applyCoupon(
            String couponCode,
            double totalAmount) {

        if (couponCode == null ||
                couponCode.isBlank()) {

            return totalAmount;

        }

        if (couponCode.equalsIgnoreCase(
                "FLY500")) {

            totalAmount -= 500;

            System.out.println(
                    "Coupon Applied : ₹500");

        }

        else {

            System.out.println(
                    "Invalid Coupon.");

        }

        return totalAmount;

    }

    // =====================================================
    // APPLY DISCOUNT
    // =====================================================

    public double applyDiscount(
            double totalAmount,
            double percentage) {

        double discount =
                totalAmount * percentage / 100;

        System.out.println(
                "Discount : ₹"
                        + discount);

        return totalAmount - discount;

    }

    // =====================================================
    // FINAL FARE
    // =====================================================

    public double calculateFinalFare(
            Flight flight,
            double excessWeight,
            boolean premiumSeat,
            boolean upgradedMeal,
            String couponCode) {

        double fare =
                calculateDynamicFare(flight);

        fare += calculateGST(fare);

        fare += calculateAirportCharges();

        fare += calculateFuelSurcharge();

        fare += calculateBaggageCharges(
                excessWeight);

        fare += calculateSeatCharges(
                premiumSeat);

        fare += calculateMealCharges(
                upgradedMeal);

        fare =
                applyCoupon(
                        couponCode,
                        fare);

        System.out.println(
                "Final Fare : ₹"
                        + fare);

        return fare;

    }

    // =====================================================
    // FARE BREAKDOWN
    // =====================================================

    public void displayFareBreakdown(
            Flight flight,
            double excessWeight,
            boolean premiumSeat,
            boolean upgradedMeal,
            String couponCode) {

        System.out.println(
                "\n======================================");
        System.out.println(
                "FARE BREAKDOWN");
        System.out.println(
                "======================================");

        double dynamicFare =
                calculateDynamicFare(flight);

        double gst =
                calculateGST(dynamicFare);

        double airport =
                calculateAirportCharges();

        double fuel =
                calculateFuelSurcharge();

        double baggage =
                calculateBaggageCharges(
                        excessWeight);

        double seat =
                calculateSeatCharges(
                        premiumSeat);

        double meal =
                calculateMealCharges(
                        upgradedMeal);

        double total =
                dynamicFare +
                        gst +
                        airport +
                        fuel +
                        baggage +
                        seat +
                        meal;

        total =
                applyCoupon(
                        couponCode,
                        total);

        System.out.println(
                "======================================");
        System.out.println(
                "Amount Payable : ₹"
                        + total);
        System.out.println(
                "======================================");

    }

}