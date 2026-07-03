package service;

import model.Seat;
import model.SeatMap;
import repo.SeatRepo;

public class SeatService {

    private SeatRepo seatRepo;
    private SeatMap seatMap;

    public SeatService(SeatRepo seatRepo, SeatMap seatMap) {
        this.seatRepo = seatRepo;
        this.seatMap = seatMap;
    }

    // Check availability
    public boolean isAvailable(String seatId) {
        Seat seat = seatRepo.findSeatById(seatId);
        return seat != null && seat.isAvailable();
    }

    // Seat selection
    public String selectSeat(String seatId, boolean exitEligible) {

        Seat seat = seatRepo.findSeatById(seatId);

        if (seat == null) return "Seat not found";
        if (!seat.isAvailable()) return "Seat already booked";

        if (seat.isEmergencyExit() && !exitEligible) {
            return "Not eligible for emergency exit seat";
        }

        seat.setAvailable(false);
        seat.setStatus("BOOKED");

        seatRepo.updateSeatStatus(seatId, "BOOKED");

        return "Seat " + seatId + " booked successfully";
    }

    // Auto assign seat
    public Seat autoAssignSeat() {
        for (Seat seat : seatMap.getAllSeats()) {
            if (seat.isAvailable()) {
                seat.setAvailable(false);
                seat.setStatus("BOOKED");
                return seat;
            }
        }
        return null;
    }

    // Extra charge
    public double calculateExtraCharge(String seatId) {
        Seat seat = seatRepo.findSeatById(seatId);
        if (seat != null && seat.isPremium()) {
            return seat.getExtraCharge();
        }
        return 0;
    }

    // Block adjacent seats (basic logic)
    public void blockAdjacentSeats(String seatId) {
        String row = seatId.replaceAll("[^0-9]", "");

        for (Seat seat : seatMap.getAllSeats()) {
            if (seat.getSeatId().startsWith(row) && seat.isAvailable()) {
                seat.setStatus("BLOCKED");
                seat.setAvailable(false);
            }
        }
    }

    // Confirm selected seat
    public void confirmSeat(String seatId) {

        Seat seat = seatRepo.findSeatById(seatId);

        if (seat != null) {
            seat.setStatus("BOOKED");
            seat.setAvailable(false);
        }

    }

    // --------------------------------------
// Release Seat
// --------------------------------------

    public void releaseSeat(String seatId) {

        Seat seat = seatRepo.findSeatById(seatId);

        if (seat == null) {

            return;

        }

        seat.setAvailable(true);

        seat.setStatus("AVAILABLE");

    }
    // --------------------------------------
// Change Seat
// --------------------------------------

    public String changeSeat(String oldSeatId,
                             String newSeatId,
                             boolean exitEligible) {

        releaseSeat(oldSeatId);

        return selectSeat(newSeatId, exitEligible);

    }
}