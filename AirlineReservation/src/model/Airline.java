package model;

public class Airline {

    private String airlineCode;
    private String airlineName;

    public Airline() {
    }

    public Airline(String airlineCode,
                   String airlineName) {

        this.airlineCode = airlineCode;
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {

        return airlineName + " (" + airlineCode + ")";
    }
}