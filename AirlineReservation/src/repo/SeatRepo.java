package repo;

import model.Seat;
import model.SeatMap;

public class SeatRepo {

    private SeatMap seatMap;

    public SeatRepo(SeatMap seatMap) {
        this.seatMap = seatMap;
    }

    public void saveSeat(Seat seat) {
        seatMap.addSeat(seat);
    }

    public Seat findSeatById(String seatId) {
        return seatMap.getSeat(seatId);
    }

    public void updateSeatStatus(String seatId, String status) {
        Seat seat = seatMap.getSeat(seatId);
        if (seat != null) {
            seat.setStatus(status);
        }
    }
}