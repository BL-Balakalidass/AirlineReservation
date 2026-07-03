package model;

public class Airport {

    private String airportCode;
    private String airportName;
    private String city;
    private String country;
    private boolean active;
    private String terminal;
    private String timezone;
    private String contactNumber;

    public Airport() {
    }

    public Airport(String airportCode,
                   String airportName,
                   String city,
                   String country) {

        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {

        return airportCode + " - " +
                airportName +
                " (" + city + ", " +
                country + ")";
    }

    public void setActive(boolean active) {

        this.active = active;

    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;

    }

    public void setTimezone(String timezone) {

        this.timezone = timezone;

    }

    public void setTerminal(String terminal) {

        this.terminal = terminal;
    }
    public String getTimezone() {

        return timezone;

    }

    public String getTerminal() {

        return terminal;

    }

    public boolean isActive() {

        return active;

    }

    public String getContactNumber() {

        return contactNumber;

    }
}