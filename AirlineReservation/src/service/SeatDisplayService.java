package service;

import model.Seat;
import model.SeatMap;

public class SeatDisplayService {

    private SeatMap seatMap;

    public SeatDisplayService(SeatMap seatMap) {
        this.seatMap = seatMap;
    }

    public void displaySeatMap() {

        System.out.println("\n===== SEAT MAP =====");

        for (Seat seat : seatMap.getAllSeats()) {

            String color;

            switch (seat.getStatus()) {
                case "AVAILABLE":
                    color = "[GREEN]";
                    break;
                case "BOOKED":
                    color = "[RED]";
                    break;
                case "BLOCKED":
                    color = "[GRAY]";
                    break;
                default:
                    color = "[UNKNOWN]";
            }

            System.out.println(
                    seat.getSeatId() +
                            " " + color +
                            " Type:" + seat.getSeatType() +
                            (seat.isPremium() ? " PREMIUM" : "") +
                            (seat.isEmergencyExit() ? " EXIT ROW" : "")
            );
        }
    }
}