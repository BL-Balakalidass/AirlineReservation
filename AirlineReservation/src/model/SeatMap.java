package model;

import java.util.*;

public class SeatMap {

    private Map<String, Seat> seats = new LinkedHashMap<>();

    public void addSeat(Seat seat) {
        seats.put(seat.getSeatId(), seat);
    }

    public Seat getSeat(String seatId) {
        return seats.get(seatId);
    }

    public Collection<Seat> getAllSeats() {
        return seats.values();
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> list = new ArrayList<>();
        for (Seat s : seats.values()) {
            if (s.isAvailable()) list.add(s);
        }
        return list;
    }
}