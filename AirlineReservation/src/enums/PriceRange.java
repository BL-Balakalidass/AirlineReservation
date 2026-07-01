package enums;

public enum PriceRange {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    PREMIUM("Premium");

    private final String displayName;

    PriceRange(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}