package model;

public class Aircraft {

    private String aircraftCode;
    private String aircraftName;
    private String manufacturer;
    private int seatingCapacity;

    public Aircraft() {
    }

    public Aircraft(String aircraftCode,
                    String aircraftName,
                    String manufacturer,
                    int seatingCapacity) {

        this.aircraftCode = aircraftCode;
        this.aircraftName = aircraftName;
        this.manufacturer = manufacturer;
        this.seatingCapacity = seatingCapacity;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return aircraftName +
                " (" + manufacturer + ")" +
                " - Capacity: " + seatingCapacity;
    }
}