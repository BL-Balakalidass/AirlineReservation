package enums;

/**
 * Represents the current status of a flight.
 */
public enum FlightStatus {

    ON_TIME,
    DELAYED,
    BOARDING,
    CANCELLED,
    LANDED;

    @Override
    public String toString() {

        switch (this) {

            case ON_TIME:
                return "On Time";

            case DELAYED:
                return "Delayed";

            case BOARDING:
                return "Boarding";

            case CANCELLED:
                return "Cancelled";

            case LANDED:
                return "Landed";

            default:
                return super.toString();
        }
    }
}