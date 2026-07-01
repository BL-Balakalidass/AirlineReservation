package util;

import enums.FlightStatus;
import enums.TravelClass;
import model.*;
import repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDataLoader {

    private FlightDataLoader(){}

    public static void loadSampleData(FlightRepository repository){
        repository.addFlights(loadFlights());
    }

    public static List<Flight> loadFlights(){
        List<Flight> flights = new ArrayList<>();

        Airport chennai = new Airport("MAA","Chennai International Airport","Chennai","India");
        Airport delhi = new Airport("DEL","Indira Gandhi International Airport","New Delhi","India");
        Airport mumbai = new Airport("BOM","Chhatrapati Shivaji Maharaj Airport","Mumbai","India");
        Airport bengaluru = new Airport("BLR","Kempegowda International Airport","Bengaluru","India");

        Airline airIndia = new Airline("AI","Air India");
        Airline indigo = new Airline("6E","IndiGo");
        Airline vistara = new Airline("UK","Vistara");

        Flight ai101 = new Flight();
        ai101.setFlightNumber("AI101");
        ai101.setAirline(airIndia);
        ai101.setAircraft("Airbus A320");
        ai101.setSourceAirport(chennai);
        ai101.setDestinationAirport(delhi);
        ai101.setDepartureTime(LocalDateTime.of(2026,7,10,8,0));
        ai101.setArrivalTime(LocalDateTime.of(2026,7,10,10,50));
        ai101.setTravelClass(TravelClass.ECONOMY);
        ai101.setBaseFare(5200);
        ai101.setTax(600);
        ai101.setServiceCharge(200);
        ai101.setAvailableSeats(120);
        ai101.setStops(0);
        ai101.setLayoverMinutes(0);
        ai101.setCabinBaggage(7);
        ai101.setCheckInBaggage(15);
        ai101.setWifi(true);
        ai101.setMeals(true);
        ai101.setEntertainment(true);
        ai101.setCancellationPolicy("24 hrs before departure");
        ai101.setModificationPolicy("Allowed with charges");
        ai101.setStatus(FlightStatus.ON_TIME);

        Flight e202 = new Flight();
        e202.setFlightNumber("6E202");
        e202.setAirline(indigo);
        e202.setAircraft("Airbus A320");
        e202.setSourceAirport(chennai);
        e202.setDestinationAirport(mumbai);
        e202.setDepartureTime(LocalDateTime.of(2026,7,10,14,0));
        e202.setArrivalTime(LocalDateTime.of(2026,7,10,16,10));
        e202.setTravelClass(TravelClass.ECONOMY);
        e202.setBaseFare(4800);
        e202.setTax(550);
        e202.setServiceCharge(180);
        e202.setAvailableSeats(95);
        e202.setStops(0);
        e202.setLayoverMinutes(0);
        e202.setCabinBaggage(7);
        e202.setCheckInBaggage(15);
        e202.setWifi(false);
        e202.setMeals(true);
        e202.setEntertainment(false);
        e202.setCancellationPolicy("24 hrs before departure");
        e202.setModificationPolicy("Allowed with charges");
        e202.setStatus(FlightStatus.ON_TIME);

        Flight uk303 = new Flight();
        uk303.setFlightNumber("UK303");
        uk303.setAirline(vistara);
        uk303.setAircraft("Boeing 737");
        uk303.setSourceAirport(delhi);
        uk303.setDestinationAirport(bengaluru);
        uk303.setDepartureTime(LocalDateTime.of(2026,7,11,9,30));
        uk303.setArrivalTime(LocalDateTime.of(2026,7,11,13,45));
        uk303.setTravelClass(TravelClass.BUSINESS);
        uk303.setBaseFare(7800);
        uk303.setTax(900);
        uk303.setServiceCharge(250);
        uk303.setAvailableSeats(40);
        uk303.setStops(1);
        uk303.setLayoverMinutes(45);
        uk303.setCabinBaggage(10);
        uk303.setCheckInBaggage(30);
        uk303.setWifi(true);
        uk303.setMeals(true);
        uk303.setEntertainment(true);
        uk303.setCancellationPolicy("48 hrs before departure");
        uk303.setModificationPolicy("Allowed with charges");
        uk303.setStatus(FlightStatus.BOARDING);

        Flight ai404 = new Flight();
        ai404.setFlightNumber("AI404");
        ai404.setAirline(airIndia);
        ai404.setAircraft("Boeing 787");
        ai404.setSourceAirport(mumbai);
        ai404.setDestinationAirport(chennai);
        ai404.setDepartureTime(LocalDateTime.of(2026,7,12,18,0));
        ai404.setArrivalTime(LocalDateTime.of(2026,7,12,20,5));
        ai404.setTravelClass(TravelClass.ECONOMY);
        ai404.setBaseFare(5100);
        ai404.setTax(600);
        ai404.setServiceCharge(200);
        ai404.setAvailableSeats(88);
        ai404.setStops(0);
        ai404.setLayoverMinutes(0);
        ai404.setCabinBaggage(7);
        ai404.setCheckInBaggage(15);
        ai404.setWifi(true);
        ai404.setMeals(true);
        ai404.setEntertainment(true);
        ai404.setCancellationPolicy("24 hrs before departure");
        ai404.setModificationPolicy("Allowed with charges");
        ai404.setStatus(FlightStatus.DELAYED);

        flights.add(ai101);
        flights.add(e202);
        flights.add(uk303);
        flights.add(ai404);

        return flights;
    }
}
