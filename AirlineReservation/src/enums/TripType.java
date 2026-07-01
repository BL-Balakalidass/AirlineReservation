package enums;

/**
 * Represents the type of journey selected by the passenger.
 */
public enum TripType {

    ONE_WAY,
    ROUND_TRIP,
    MULTI_CITY;

    @Override
    public String toString() {

        switch (this) {

            case ONE_WAY:
                return "One Way";

            case ROUND_TRIP:
                return "Round Trip";

            case MULTI_CITY:
                return "Multi City";

            default:
                return super.toString();
        }
    }
}