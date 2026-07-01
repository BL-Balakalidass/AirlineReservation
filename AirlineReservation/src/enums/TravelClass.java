package enums;

/**
 * Represents the available travel classes.
 */
public enum TravelClass {

    ECONOMY,
    PREMIUM_ECONOMY,
    BUSINESS,
    FIRST_CLASS;

    @Override
    public String toString() {

        switch (this) {

            case ECONOMY:
                return "Economy";

            case PREMIUM_ECONOMY:
                return "Premium Economy";

            case BUSINESS:
                return "Business";

            case FIRST_CLASS:
                return "First Class";

            default:
                return super.toString();
        }
    }
}